package com.hakan.toprak.model;

public class MaxNumber implements MaxNumberInterface{

	@Override
	public int[] getSolution(int[] nums, int k) {
		int loop = (nums.length-k)+1;
		int[] maxarray= new int[loop];  
		for(int a = 0;a<loop;a++) {
		 int max = nums[a];
		    for (int ktr = a; ktr < a+k; ktr++) {
		        if (nums[ktr] > max) {
		            max = nums[ktr];
		        }
		    }
		    maxarray[a]= max;
		}
		return maxarray;    
	}

}
