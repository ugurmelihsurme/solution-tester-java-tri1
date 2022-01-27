/*
 * Copyright (c) 2021. Licenced to BTK  ATP Project
 */
package bites;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gulsen.ozcan
 * @createdAt : 20.01.2022
 **/

interface MaxNumberInterface {
    public int[] getSolution(int[] nums, int k);
}

public class MaxNumberInterfaceImpl implements MaxNumberInterface {
  @Override
    public int[] getSolution(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        solve(nums, k, 0,result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void solve(int [] nums, int k, int offset, List<Integer> result) {
        if(nums.length - offset < k) {
            return;
        }

        int maxValue = nums[offset];

        for(int i=offset+1; i < offset+k; i++) {
            maxValue = Math.max(maxValue, nums[i]);
        }

        result.add(maxValue);
        solve(nums, k, offset+1, result);
    }

}
