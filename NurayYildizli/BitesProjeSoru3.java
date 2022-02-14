/*Soru 3 Cevap Kodlama- NURAY YILDIZLI*/
import java.util.Scanner;
interface Sqrt {
	 public int getSolution(int x);
}
public class BitesProjeSoru3 implements Sqrt{
	 
	// Say�n�n karak�k�n� bulma i�lemi
	public int getSolution(int number){
	    int start = 0;
		int end = number;
	    int mid;
	    
	    float ans = 0;
	    while (start <= end) {
	        mid = (start + end) / 2;
	        if (mid * mid == number) {
	            ans = mid;
	            break;
	        }
	 
	        if (mid * mid < number) {
	            ans=start;
	            start = mid + 1;
	        }
	        else {
	            end = mid - 1;
	        }
	    }
	 
	    float increment = (float) 0.1;
	    for (int i = 0; i < 5; i++) {
	        while (ans * ans <= number) {
	            ans += increment;
	        }
	        ans = ans - increment;
	        increment = increment / 10;
	    }
	    return (int)ans;
	}
	 
	// Driver Code
	public static void main(String[] args)
	{
		//Kullan�c�dan say� de�eri al
	    Scanner in = new Scanner(System.in);
	    System.out.println("Say� giriniz:");

	    int number = in.nextInt();
	    if(number>=0 && number<=231) {
	    	//Girilen say� de�eri kurallara uygun ise fonksiyonu �a��r
	    	BitesProjeSoru3 obje = new BitesProjeSoru3();
	    	System.out.println(obje.getSolution(number));
	    }else {
	    	System.out.println("Girmi� oldu�unuz de�er 0 ile 231 aras�nda bir say� olmal�d�r!");
	    }
	   
	}
}
