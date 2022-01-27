package bites;

interface Sqrt {
    public int getSolution(int x);
}

public class SqrtImpl implements Sqrt{
    @Override
    public int getSolution(int x) {
        return sqrtSearch(0,x,x);
    }

    static int sqrtSearch(int low, int high, int N)
    {
        if (low <= high) {
            int mid = (int)(low + high) / 2;

            if ((mid * mid <= N)
                    && ((mid + 1) * (mid + 1) > N)) {
                return mid;
            }

            else if (mid * mid < N) {
                return sqrtSearch(mid + 1, high, N);
            }
            else {
                return sqrtSearch(low, mid - 1, N);
            }
        }
        return low;
    }
}


