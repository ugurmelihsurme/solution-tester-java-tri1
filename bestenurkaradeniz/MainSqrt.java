import functions.SquareRoot;

import java.util.Scanner;

public class MainSqrt {
    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println("Please, enter a number");
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        System.out.println("Square root of " + squareRoot.getSolution(num));
    }
}
