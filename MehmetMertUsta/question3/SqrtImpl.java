package mmert.usta.question3;

public class SqrtImpl implements Sqrt{
    @Override
    public int getSolution(int x) {
        /*
        a*a = x => Çarpımları x olan sayıyı buluyoruz.
        0 --middle-- x => Binarysearch mantığında orta elemanı buluyoruz.
        middle*middle = x => find middle
        middle*middle < x =>Çarpım eğer x'ten küçükse  middle+1...x aralığına bakıyoruz.
        middle*middle > x =>Çarpım eğer x'ten büyükse  0...middle aralığına bakıyoruz.
    	*/
    	
    	if(x<0)
    		return 0;

        int leftSide = 0;
        int rightSide = x+1;

        while (leftSide < rightSide)
        {
            int middleVal = (leftSide+rightSide)/2;

            if(middleVal*middleVal == x)
            {
                return middleVal;
            }
            else if(middleVal*middleVal < x)
            {
            	leftSide = middleVal+1;
            }
            else {
            	rightSide = middleVal ;
            }


        }

        return leftSide-1;
    }
}
