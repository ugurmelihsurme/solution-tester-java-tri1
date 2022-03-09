
/*
SORU1: Penceredeki en büyük değeri bulma
Rabia Kanık
 */

//Arayüz
public interface MaxNumberInterface {
   public int[] getSolution(int[] nums, int k);
}

//Çözüm Algoritması
class Solution implements MaxNumberInterface{
   public int[] getSolution(int nums[], int k)
    {
        int j, max;
        for (int i = 0; i <= nums.length - k; i++) {

            max = nums[i];
            for (j = 1; j < k; j++) {
                if (nums[i + j] > max)
                    max = nums[i + j];
            }
            System.out.print(max + " ");
        }
        return nums;
    }
}

class Main{
    public static void main(String args[])
    {
        //case1:
        int nums[] = { -10, -1200, 3, -4, 5, -46, 7, 8, 9, 10,20,30,40,50,60 };

        //case2:
        //int nums[] = {1};

        int k = 3;

        MaxNumberInterface m1= new Solution();
        m1.getSolution(nums,k);

     }
}




