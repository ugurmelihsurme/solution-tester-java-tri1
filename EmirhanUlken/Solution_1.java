
public class Solution_1 implements MaxNumberInterface {

	int[] solution;
	boolean started = false;
	int i;

	@Override
	public int[] getSolution(int[] nums, int k) {

		if (!started) {
			solution = new int[nums.length - k + 1];
			i = 0;
			started = true;
		}

		if (nums.length < k) {
			started = false;
			return solution;
		} else {
			solution[i] = max(arrSlice(nums, 0, k));
			i += 1;
			return getSolution(arrSlice(nums, 1, nums.length), k);
		}
	}

	public int[] arrSlice(int[] arr, int start, int end) {

		int[] slice = new int[end - start];

		for (int i = 0; i < slice.length; i++) {
			slice[i] = arr[start + i];
		}

		return slice;
	}

	public int max(int... n) {
		int i = 0;
		int max = n[i];

		while (++i < n.length) {
			if (n[i] > max) {
				max = n[i];
			}
		}

		return max;
	}

}
