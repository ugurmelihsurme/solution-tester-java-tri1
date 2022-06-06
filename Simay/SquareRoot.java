import java.util.Scanner;

public class SquareRoot implements Sqrt {
    @Override
    public int getSolution(int x) {
        double t;
        double sqrtRoot = x / 2;
        do {
            t = sqrtRoot;
            sqrtRoot = (t + (x / t)) / 2;
        } while ((t - sqrtRoot) != 0);
        return (int) sqrtRoot;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hesaplanacak tam sayı değerini giriniz: ");
        int solution = squareRoot.getSolution(scanner.nextInt());
        System.out.println("Verilen sayının karekökü: " + solution);
    }
}
