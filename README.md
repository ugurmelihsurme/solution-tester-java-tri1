Rabia Kanık 40 + 30 + 20 = 90 point

MaxWindow -> 40 

fix as below;

public int[] maxSlidingWindow(int[] nums, int k) {
int j, max;
int[] result= new int[nums.length - k+1];
for (int i = 0; i <= nums.length - k; i++) {

            max = nums[i];
            for (j = 1; j < k; j++) {
                if (nums[i + j] > max)
                {
                    max = nums[i + j];
                   
                 }
            }
             result[i] = max; 
           //System.out.print(max + " ");
        }
        return result;
    }

49 / 61 test cases passed.
Status: Time Limit Exceeded

BinaryTree -> 30

Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
Memory Usage: 45.1 MB, less than 22.66% of Java online submissions for Populating Next Right Pointers in Each Node II.

Sqrt -> 20
Runtime: 1 ms, faster than 99.20% of Java online submissions for Sqrt(x).
Memory Usage: 41.4 MB, less than 29.61% of Java online submissions for Sqrt(x).
