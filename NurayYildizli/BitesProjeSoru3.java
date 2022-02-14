/*Soru 3 Cevap Kodlama- NURAY YILDIZLI*/
import java.util.Scanner;
interface Sqrt {
	 public int getSolution(int x);
}
public class BitesProjeSoru3 implements Sqrt{
	 
	// Sayýnýn karakökünü bulma iþlemi
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
		//Kullanýcýdan sayý deðeri al
	    Scanner in = new Scanner(System.in);
	    System.out.println("Sayý giriniz:");

	    int number = in.nextInt();
	    if(number>=0 && number<=231) {
	    	//Girilen sayý deðeri kurallara uygun ise fonksiyonu çaðýr
	    	BitesProjeSoru3 obje = new BitesProjeSoru3();
	    	System.out.println(obje.getSolution(number));
	    }else {
	    	System.out.println("Girmiþ olduðunuz deðer 0 ile 231 arasýnda bir sayý olmalýdýr!");
	    }
	   
	}
}
