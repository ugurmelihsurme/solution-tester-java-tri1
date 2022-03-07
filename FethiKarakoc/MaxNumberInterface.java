package bitesSoru1;

public interface MaxNumberInterface {
	public int[] getSolution(int[] nums, int k);
}

class Challange implements MaxNumberInterface {
		
	@Override
	public int[] getSolution(int[] nums, int k) {
		
		int[] resultArray = new int[nums.length - (k - 1)];
		int[] destArr = new int[k];
		for (int i = 0; i < nums.length - (k-1); i++) {			
			System.arraycopy(nums, i, destArr, 0, k);
			resultArray[i] = getMaxValue(destArr, k);
		}
		
		return resultArray;
	}
	
	private int getMaxValue(int[] array, int k) {	
		
		int max = array[0];
		
		for (int i = 1; i < k; i++) {			
			if(max < array[i]) max = array[i];
		}
		
		return max;
	}
}
