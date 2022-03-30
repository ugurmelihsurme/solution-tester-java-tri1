
public class Q3 implements Sqrt {
	
	
	public int getSolution(int x) {
		
		if(x == 1)
		{
			return 1;
		}
		double x1 = 0;
		double temp = -1;
		double divisor = (x / 10) != 0 ? (x / 10) :  x / 2;
		
		while((int)temp != (int)x1)
		{		
			 temp = x1;
			 
			 x1 = (divisor+(x/divisor))/2;
			 divisor = x1;
		
		}
	    return (int)x1;
	
	}

}
