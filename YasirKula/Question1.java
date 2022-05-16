package com.yasirkula.bitesdemo;

public class Question1 implements MaxNumberInterface
{
	private static class Element
	{
		public int value;
		public int forwardsMax, backwardsMax;
		
		public Element( int value, int forwardsMax )
		{
			this.value = value;
			this.forwardsMax = forwardsMax;
			this.backwardsMax = 0;
		}
	}
	
	public int[] getSolution( int[] nums, int k )
	{
		int[] result;
		if( k == 1 || nums.length == 1 )
			result = nums.clone(); // Or return nums directly, depending on whether or not nums is immutable
		else if( k == 2 ) // Can be calculated efficiently with no space requirements
		{
			result = new int[nums.length - 1];
			int prevValue = nums[0];
			for( int i = 1; i < nums.length; i++ )
			{
				int value = nums[i];
				result[i - 1] = Math.max( value, prevValue );
				prevValue = value;
			}
		}
		else
		{
			// The logic is the same as queue implementation with 2 stacks but it uses a single array to represent
			// these 2 stacks which is sufficient and more optimized for this problem (pivotIndex is the index that
			// separates these 2 stacks)
			int resultIndexOffset = k - 1;
			result = new int[nums.length - resultIndexOffset];
			
			// Filling the 'enqueue' stack
			Element[] elements = new Element[k];
			int currentMax = Integer.MIN_VALUE;
			for( int i = 0; i < k; i++ )
			{
				int value = nums[i];
				currentMax = Math.max( value, currentMax );
				elements[i] = new Element( value, currentMax );
			}
			
			result[0] = currentMax;
			
			for( int i = k, pivotIndex = k - 1; i < nums.length; i++ )
			{
				if( ++pivotIndex == k )
				{
					pivotIndex = 0;
					
					// Filling the 'dequeue' stack
					currentMax = Integer.MIN_VALUE;
					for( int j = k - 1; j >= 0; j-- )
					{
						currentMax = Math.max( elements[j].value, currentMax );
						elements[j].backwardsMax = currentMax;
					}
				}
				
				int value = nums[i];
				
				Element element = elements[pivotIndex];
				element.value = value;
				element.forwardsMax = ( pivotIndex > 0 ) ? Math.max( value, elements[pivotIndex - 1].forwardsMax ) : value;
				
				result[i - resultIndexOffset] = ( pivotIndex < k - 1 ) ? Math.max( element.forwardsMax, elements[pivotIndex + 1].backwardsMax ) : element.forwardsMax;
			}
		}
		
		return result;
	}
}