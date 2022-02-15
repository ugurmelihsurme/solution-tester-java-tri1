
import java.util.Arrays;
import java.util.stream.IntStream;

interface MaxNumberInterface {

    public int[] getSolution(int[] nums, int k);
}

class MaxNumberInterfaceImpl implements MaxNumberInterface {

    @Override
    public int[] getSolution(int[] nums, int k) {

        int[] outputArray = {};
        int[] kArray =  new int[k];

        int controlArrayElement = 0;

        if (nums.length>=1 && nums.length<=105 && k>=1 && k<=nums.length){
                for (int i = 0; i < k; i++) {
                    if (nums[i] <= -104 || nums[i] >= 104) {
                        controlArrayElement++;
                        break;
                    }
                }
        }
        if (controlArrayElement>0){
            return null;
        }else{
            if (nums.length>=k) {
                for (int i=0; i<k; i++) {
                    kArray[i] = nums[i];
                }
                outputArray = Arrays.copyOf(outputArray, outputArray.length + 1);
                outputArray[outputArray.length - 1] = Arrays.stream(kArray).max().getAsInt();

                int[] newNums = Arrays.copyOfRange(nums,1,nums.length);
                return IntStream.concat(Arrays.stream(outputArray), Arrays.stream(getSolution(newNums,k))).toArray();
            }else{
                return outputArray;
            }
        }
    }
}