package bites;

public class SqrtImplementation implements Sqrt {

    public int getSolution(int x) {

        if (x < 0 || x > 230) {
            return 0;
        }
        double temp;
        double sqrt = (double) x / 2;
        do {
            temp = sqrt;
            sqrt = (temp + (x / temp)) / 2;
        }
        while ((temp - sqrt) != 0);
        return (int) sqrt;
    }

}
