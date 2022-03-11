/*
SORU1: WINDOW
Rabia Kanık
 */

import java.util.Arrays;
import java.util.PriorityQueue;

//Arayüz
public interface MaxNumberInterface {
    public int[] getSolution(int[] nums, int k);
}

//Çözüm Algoritması
class Solution implements MaxNumberInterface{
    public int[] getSolution(int nums[], int k)
    {
        if (k <= 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            queue.add(-nums[i]);
        }
        int[] max = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            queue.add(-nums[j]);
            max[i] = -queue.peek();
            queue.remove(-nums[j - k + 1]);
        }
        return max;
    }
}
class Main{
    public static void main(String args[])
    {
        MaxNumberInterface m1= new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.print(Arrays.toString(m1.getSolution(nums,k)));
    }
}
