
public class Solution_3 implements Sqrt {

	double ans;

	@Override
	public int getSolution(int x) {

		// 46340 is max for sqrt of max int (2147483647), so 46341 is last check
		for (int i = 0; i < 46342; i++) {

			if ((double) i * (double) i > x) {
				return i - 1;
			}

			if (i * i == x) {
				return i;
			}
		}

		return -1;
	}
}
