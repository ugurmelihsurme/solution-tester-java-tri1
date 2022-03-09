/*
SORU3: KAREKOK HESAPLAMA
Rabia Kanık
 */

public interface Sqrt {
    public int getSolution(int x);
}

class Solution implements Sqrt{
    public int getSolution(int x){

         double t=0;
         double squareroot = x/2;

         // Girilen sayı 1 veya 0 ise
         if(0<=x && x<=1){
             if (x==0)
                return 0;
             else if (x==1)
                return 1;
         }
         // Girilen sayı 1'den büyük ise
         else if (x >1) {
             do {
                 t = squareroot;
                 squareroot = (t + (x / t)) / 2;
             } while ((t - squareroot) != 0);
         }
        return (int) squareroot;
    }
}

class Main{
    public static void main( String args[]){

        Sqrt s1 = new Solution();
        System.out.println("kök:"+s1.getSolution(1));

    }
}



