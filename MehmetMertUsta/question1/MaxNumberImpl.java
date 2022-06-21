package mmert.usta.question1;

import java.util.LinkedList;

public class MaxNumberImpl implements MaxNumberInterface {
    @Override
    public int[] getSolution(int[] nums,int k) {
        if (k == 0 ||  k<1 || k > nums.length ) return new int[0];

        int arrayLength = nums.length;
        int windowSize = arrayLength - k + 1;
        int[] windowMaxElements = new int[windowSize];

        LinkedList<Integer> window = new LinkedList<Integer>();

        for (int i = 0; i < arrayLength; i++)
        {
            // Pencerede yer almıyorsa ilk elemanı sil
            if (!window.isEmpty() && window.getFirst() + k <= i)
            {
                window.removeFirst();
            }

            // Penceredeki en yüksek değeri bul
            while (!window.isEmpty() && nums[window.getLast()] <= nums[i])
            {
                window.removeLast();
            }

            window.add(i);



            // Değer pencerede yer alıyorsa - max değeri ekle
            int index = i + 1 - k;
            if (index >= 0)
            {
                windowMaxElements[index] = nums[window.getFirst()];
            }
        }

        return windowMaxElements;
    }

}


