package bites;


public class MaxNumberImplements implements MaxNumberInterface{

	@Override
	public int[] getSolution(int[] nums, int k) {
		return getResultArray(nums,k);
		
	}

	private int[] getResultArray(int[] nums, int k) {
		
	   int maxArrayLenght = nums.length-k+1;
	   int result []= new int[maxArrayLenght];

	   for	(int i =0;i<maxArrayLenght;i++) {
	   int[] newArray  = getNewSliceArray(nums, i, i+k);
	   result[i] = getMaxValue(newArray,k);
	  }
	return result;
}


private  int [] getNewSliceArray(int [] nums ,int  startIndex,int  endIndex) {
	  int[] newArray = new int[endIndex - startIndex];   
      for (int i = 0; i < newArray.length; i++)   
      {   
          newArray[i] = nums[startIndex + i];   
      }    
      return newArray;
}
		

private int getMaxValue(int array[], int arrayLenght) {
	  int maxValue;
	  if (arrayLenght == 1) {
	    maxValue = array[0];
	    return maxValue;
	  }
	  else {
	    return maxValue = array[arrayLenght - 1] > getMaxValue(array, arrayLenght - 1) ? array[arrayLenght - 1] : getMaxValue(array, arrayLenght - 1);
	  }
	}

}