package src;

public class SqrtImpl implements Sqrt {

    @Override
    public int getSolution(int x) {

        if(x == 0 || x == 1){
            return x;
        }

        long i = 2;
        while (i*i <= x) {
            i++;
        }

        return (int)i -1;

    }
}
