package com.yasirkula.bitesdemo;

public class Question3 implements Sqrt
{
	public int getSolution( int x )
	{
		if( x <= 1 )
			return x;
		
		// We can either handle integer overflow in the binary search, or limit the max bounds
		// of the binary search to the Integer.MAX_VALUE's square root (better in this case IMO)
		final int SQRT_OF_INT_MAX = 46340; // Square-root of 2,147,483,647
		
		// Calculate the solution using binary search
		int min = 0, max = Math.min( SQRT_OF_INT_MAX, x / 2 ), middle = 0, middleSqr = 0;
		while( min <= max )
		{
			middle = min + ( max - min ) / 2;
			middleSqr = middle * middle;
			if( middleSqr == x )
				return middle;
			else if( middleSqr < x )
				min = middle + 1;
			else
				max = middle - 1;
		}
		
		return ( middleSqr < x ) ? middle : ( middle - 1 );
	}
}