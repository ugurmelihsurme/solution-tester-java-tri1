package bites;

public class SqrtImplements implements Sqrt {

	@Override
	public int getSolution(int x) {
		return getSquareRoot(x);
	}
	
	private int getSquareRoot(int number)
    {
		if (number == 0 || number == 1)
            return number;
 
        int counter = 1, result = 1;
         
        while (result <= number) {
            counter++;
            result = counter * counter;
        }
        return counter - 1;
    }

}
