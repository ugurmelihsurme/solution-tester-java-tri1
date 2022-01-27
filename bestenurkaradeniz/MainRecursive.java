import functions.Recursive;

import java.util.Arrays;
import java.util.Scanner;

public class MainRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an array like 1 2 3 4 5 6 7");
        String[] data = scanner.nextLine().split(" ");

        int[] numbers = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }
        System.out.println("Please enter k value");
        int kValue = scanner.nextInt();

        System.out.println(Arrays.toString(numbers));
        Recursive recursive = new Recursive();
        System.out.println(Arrays.toString(recursive.getSolution(numbers, kValue)));
    }
}
