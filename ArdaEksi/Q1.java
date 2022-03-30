import java.util.ArrayDeque;
import java.util.Deque;


public class Q1 implements MaxNumberInterface {

	
	
	public int[] getSolution(int[] nums, int k)
	{			
		if(k == 1)
		{
			return nums;
		}
	
		Deque<Integer> maxQueue = new ArrayDeque<>();
        
        for (int i = 0; i < k; i++) 
        {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]) 
            {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[i]);
        }    
        
        int[] output = new int[nums.length-k+ 1];
        output[0] = maxQueue.peekFirst(); 
        for (int i=1;i+k-1 < nums.length; i++) 
        {
        	
            int beginVal = nums[i];
            int endVal = nums[i+k-1];
            
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < endVal) 
            {  	
                maxQueue.removeLast();
            }
            maxQueue.addLast(endVal); 
              
            if(nums[i-1] == maxQueue.peekFirst()) 
            {
                maxQueue.removeFirst();
            }
            output[i] = maxQueue.peekFirst();           
        }
        
        return output; 
	}
	
	
	
}
