package src;

public class MaxNumberInterfaceImpl implements MaxNumberInterface {

	@Override
	public int[] getSolution(int[] nums, int k) {

		int result[] = new int[nums.length -k +1];
		int resultIndexCounter = 0;

		int indexQueue[] = new int[k];
		int indexQueueSize = 0;

		for(int i = 0; i < k; i++) {
			indexQueue[i] = -1;
		}

		for(int i = 0; i < k; i++) {
			while (indexQueueSize > 0 && nums[indexQueue[indexQueueSize-1]] <= nums[i]){
				indexQueue[indexQueueSize--] = -1;
			}

			indexQueue[indexQueueSize++] = i;
		}

		for(int i = k; i < nums.length; i++ ){
			result[resultIndexCounter++] = nums[indexQueue[0]];

			while (indexQueueSize != 0 && indexQueue[0] <= i -k) {
				int j = 1;
				while (j < k && indexQueue[j] != -1 ){
					indexQueue[j-1] = indexQueue[j];
					j++;
				}
				indexQueue[j-1] = -1;
				indexQueueSize--;
			}

			while (indexQueueSize != 0 && nums[indexQueue[indexQueueSize-1]] <= nums[i]){
				indexQueue[indexQueueSize--] = -1;
			}

			indexQueue[indexQueueSize++] = i;
		}

		result[resultIndexCounter++] = nums[indexQueue[0]];

		return result;
	}

}


