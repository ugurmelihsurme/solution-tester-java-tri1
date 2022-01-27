package functions;

import interfaces.MaxNumberInterface;

import java.util.Arrays;
import java.util.Scanner;

public class Recursive implements MaxNumberInterface {
    @Override
    public int[] getSolution(int[] nums, int k) {
        int[] newArr;
        int[] biggest = {};

        for (int i = 0; i < nums.length; i++) {
            newArr = Arrays.copyOfRange(nums, i, i + k);
            if (nums.length - i < k) {
                return biggest;
            }
            int size = newArr.length;
            Arrays.sort(newArr);
            int big = newArr[size - 1];

            biggest = add_element(i, biggest, big);
        }
        return biggest;
    }

    public static int[] add_element(int n, int arr[], int element) {
        int i;
        int[] newArray = new int[n + 1];

        for (i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[n] = element;
        return newArray;
    }
}
