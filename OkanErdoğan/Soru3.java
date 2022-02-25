
public class Soru3 implements Sqrt {

	@Override
	public int getSolution(int x) {
		// TODO Auto-generated method stub
		
		if(x < 0) {
			throw new IllegalArgumentException("Illegal argument");
		}
		if(x == 0) {
			return 0;
		} 
		
		double root = (double) x;
		double last = root+1;
		 while(last - root > 0.00001){
			last=root;
			root = ((x/root) + root)/2;
		}
		
		return (int) root;
	}
	
}
