package com.hakan.toprak.model;

public class SqrtCalculate implements Sqrt{

	@Override
	public int getSolution(int x) {
		Double t;  
		Double sqrtroot=(double) (x/2);  
		do   
		{  
		t=sqrtroot;  
		sqrtroot=(t+(x/t))/2;  
		}   
		while((t-sqrtroot)!= 0);  
		
	    int number = sqrtroot.intValue();
		return number;
		
	}

}
