package functions;

import interfaces.Sqrt;

public class SquareRoot implements Sqrt {
    @Override
    public int getSolution(int x) {
        int result;
        int squareRoot = x / 2;

        do {
            result = squareRoot;
            squareRoot = (result + (x / result)) / 2;

        } while (((result - squareRoot) != 0));

        return squareRoot;
    }
}
