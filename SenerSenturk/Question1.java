import java.util.*;
import java.util.stream.Collectors;

public class Question1 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int nums[] = {2, 3, -104, 5, -10, 6, 11, 5};
        Scanner input = new Scanner(System.in);
        /* k input value set from screen */
        int k = input.nextInt();

        int newArry[] = solution.execute(nums, k);
        System.out.println("------new nums-----");
        for (int i = 0; i < newArry.length; i++)
            System.out.println(newArry[i]);

    }

}

class Solution implements MaxNumberInterface {
    List<Integer> sayi = new ArrayList<Integer>();
    int newArry[];
    int i = 0;

    public int[] execute(int[] nums, int k) {

        if(!(1 <= nums.length && nums.length <=105)){
            System.out.println("Invalid Array size.!!!");
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++){
            if(!(-104 <= nums[i] && nums[i] <=104)){
                System.out.println("Invalid Array value");
                return new int[0];
            }
        }
        if(!(1 <= k && k <=nums.length)){
            System.out.println("Invalid k value!!!");
            return new int[0];
        }

        return this.getSolution(nums, k);
    }

    @Override
    public int[] getSolution(int[] nums, int k) {
        int[] partArray = Arrays.copyOfRange(nums, this.i, this.i + k);
        /* partArray convert to List object */
        List<Integer> list = Arrays.stream(partArray)
                .boxed()
                .collect(Collectors.toList());
        /* list sorting for get max value */
        Collections.sort(list);
        /*   create newArry from ArrayList object */
        if (i + k > nums.length) {
            /* create newArry from ArrayList object */
            newArry = new int[sayi.size()];
            for (int j = 0; j <= this.sayi.size() - 1; j++) {
                newArry[j] = this.sayi.get(j);
            }
            return newArry;
        } else {
            this.i++;
            /* add max value in list */
            this.sayi.add(list.get(k - 1));
            return getSolution(nums, k);
        }
    }
}

interface MaxNumberInterface {
    public int[] getSolution(int[] nums, int k);
}