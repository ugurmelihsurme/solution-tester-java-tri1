import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        Scanner input = new Scanner(System.in);
        /* x input value set from screen */
        int x = input.nextInt();
        if (x < 1)
            System.out.println("Invalid x value");
        else System.out.println(solution.getSolution(x));
    }
}

interface Square {
    public int getSolution(int x);
}


class Solution3 implements Square {

    @Override
    public int getSolution(int x) {
        int k;
        if (x == 1) return x;
        int sqr = x / 2;

        do {
            k = sqr;
            sqr = (k + (x / k)) / 2;
        } while ((k - sqr) != 0);

        return sqr;
    }
}
