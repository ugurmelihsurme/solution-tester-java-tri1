import java.util.Arrays;

public class Soru1 implements MaxNumberInterface {

	@Override
	public int[] getSolution(int[] nums, int k) {
				
		if(nums.length < 1 || nums.length > Math.pow(10, 5)) {
			throw new IllegalArgumentException("Illegal argument");
		}
		if(k < 1 || nums.length < k) {
			throw new IllegalArgumentException("Illegal argument");
		}
		
		int bigNumber = nums[0];
		for(int index = 1; index < k; index++) {
			if(nums[index] > bigNumber) {
				bigNumber = nums[index];
			}
		}
		
		if(nums.length == k) {
			int[] endArray = {bigNumber};
			return endArray;
		}
		
		int[] recursiveArray = getSolution(Arrays.copyOfRange(nums, 1, nums.length),k);
		int[] currentBig = {bigNumber};
		int[] result = new int[recursiveArray.length + 1];
		System.arraycopy(currentBig, 0, result, 0, currentBig.length);
		System.arraycopy(recursiveArray, 0, result, currentBig.length, recursiveArray.length);  
	
		return result;
	}
	
}
