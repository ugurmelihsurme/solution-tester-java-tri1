package bitesSoru3;

public interface Sqrt {
	public int getSolution(int x);
}

class Challange implements Sqrt {
	
	@Override
	public int getSolution(int x) {
		
		double guess;
		double sqRoot = x/2;
		do {
			guess = sqRoot;
			sqRoot = (guess+(x/guess))/2;
		} while ((guess - sqRoot) != 0);
		
		return (int) Math.floor(sqRoot);
	}	
}

