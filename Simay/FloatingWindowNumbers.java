import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FloatingWindowNumbers implements MaxNumberInterface {
	public static void main(String[] args) {
	   int fwNumbers[] ={1, 3, -2, -7, 9, 18, 25};
	   FloatingWindowNumbers floatingWindowNumbers = new FloatingWindowNumbers();
	   int[] solutionList = floatingWindowNumbers.getSolution(fwNumbers, 3);
	   System.out.println("Max values of list: "+Arrays.toString(solutionList));
	}
	
    @Override
    public int[] getSolution(int[] nums, int k) {
    	  List<Integer> resultList = new ArrayList<>();
    	  List<Integer> arr=Arrays.stream(nums).boxed().collect(Collectors.toList());
          LinkedList<Integer> window= new LinkedList<>(arr.subList(0, k));
          resultList.add(getMax(window));
          for (int i = k; i < arr.size(); i++) {
              window.pollFirst();
              window.push(arr.get(i));
              int maxValue=getMax(window);
              resultList.add(maxValue);
          }
        int[] resultArray=resultList.stream().mapToInt(Integer::intValue).toArray();
      	return resultArray;
    }
    
    private static int getMax(LinkedList<Integer> window) {
		return window.stream().mapToInt(value->value).max().getAsInt();
	}

  
}
