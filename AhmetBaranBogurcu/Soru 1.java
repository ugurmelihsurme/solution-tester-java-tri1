package com.bites;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter k value:");
            int k = sc.nextInt();

            System.out.println("How many number do you want to add?");
            int numCount = sc.nextInt();

            System.out.println("\nNumbers");
            List<Integer> numList = new ArrayList<>();
            int itemOfNums = 1;
            while (numCount > 0) {
                System.out.println(itemOfNums + ":");
                numList.add(sc.nextInt());

                ++itemOfNums;
                --numCount;
            }

            int[] nums = numList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            MaxNumberInterfaceImpl maxNumberInterface = new MaxNumberInterfaceImpl();

            int[] solutionNumbers = maxNumberInterface.getSolution(nums, k);
            System.out.println(Arrays.toString(solutionNumbers));
        } catch (InputMismatchException ex) {
            System.out.println("Error:Invalid character!");
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }
}

class MaxNumberInterfaceImpl implements MaxNumberInterface {

    @Override
    public int[] getSolution(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int slideCount = nums.length - k + 1;
        int[] solutionNumbers = new int[slideCount];

        int firstNumber = 0;
        int listCount = 0;

        while (slideCount > 0) {
            int tempK = k;
            int tempFirstNumber = firstNumber;
            solutionNumbers[listCount] = nums[firstNumber];

            while (k > 0) {
                if (nums[firstNumber] > solutionNumbers[listCount]) {
                    solutionNumbers[listCount] = nums[firstNumber];
                }

                ++firstNumber;
                --k;
            }
            k = tempK;
            firstNumber = tempFirstNumber;

            ++firstNumber;
            ++listCount;
            --slideCount;
        }

        return solutionNumbers;
    }
}

interface MaxNumberInterface {
    public int[] getSolution(int[] nums, int k) throws Exception;
}
