
interface Sqrt {
    public int getSolution(int x);
}

class SqrtImpl implements Sqrt {

    @Override
    public int getSolution(int x) {

        if (x>=0){
            if (x<=230){
                double result;
                double xValue = x;

                double squareRoot = xValue /2;

                do {
                    result = squareRoot;
                    squareRoot = (result + (xValue / result)) / 2;
                } while ((result - squareRoot) != 0);

                return (int)squareRoot;
            }else{
                System.out.println("x<=230 koşulu sağlanmalıdır");
                return 0;
            }
        }else{
            System.out.println("x>=0 koşulu sağlanmalıdır");
            return 0;
        }
    }
}
