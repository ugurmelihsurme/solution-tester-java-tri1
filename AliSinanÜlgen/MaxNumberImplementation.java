package bites;

import java.util.Arrays;

public class MaxNumberImplementation implements MaxNumberInterface {


    public int[] getSolution(int[] nums, int k) {

        if ((nums.length < k || k < 1) || (nums.length > 105 || nums.length < 1)) {
            return new int[0];
        }
        if (Arrays.stream(nums).max().getAsInt() > 104 || Arrays.stream(nums).min().getAsInt() < -104) {
            return new int[0];
        }
        return solutionRecursive(nums, k, new int[0], 0);

    }

    public static int[] solutionRecursive(int[] nums, int k, int[] resultSet, int startIndex) {

        if (startIndex <= nums.length - k) {
            int[] window = new int[k];
            System.arraycopy(nums, startIndex, window, 0, k);
            int maxValue = Arrays.stream(window).max().getAsInt();
            resultSet = Arrays.copyOf(resultSet, resultSet.length + 1);
            resultSet[resultSet.length - 1] = maxValue;
            startIndex++;
            return solutionRecursive(nums, k, resultSet, startIndex);
        } else {
            return resultSet;
        }
    }

}
