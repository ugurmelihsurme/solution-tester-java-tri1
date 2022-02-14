/*Soru 1 Cevap Kodlama - NURAY YILDIZLI*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
interface MaxNumberInterface{
	 public int getSolution(int[] nums, int k); 
}

public class BitesProje implements MaxNumberInterface{
    @Override
    //Girilen parametrelerin kural kontrolü
    public int getSolution(int[] nums, int k){
    	BitesProje obje = new BitesProje();
    	int i;
    	int arrayControl = 0;
    	if((1<=nums.length) && (nums.length<=105)) {
    		for(i=0;i<nums.length;i++) {
    			if(nums[i]<=-104 && nums[i]>=104) {
    				arrayControl++;
    			}
    		}
    	}else {
    		System.out.println("Dizi uzunluðu 1 den büyük 105 den küçük olmalýdýr.");
    	}
    	
    	if(arrayControl>0) {
    		System.out.println("Dizi deðerleri -104 den küçük ve 104 den büyük olamaz! Girmiþ olduðunuz deðerleri kontrol ediniz!");
    	}else {
    		if(k>=1 && k<=nums.length) {
    			int g = 0;
    			obje.WindowMaxCalc(nums,k,nums.length,g);
    		}else {
    			System.out.println("k deðeriniz hatalý kontrol ediniz!Girmiþ olduðunuz k deðeri dizi boyutuna eþit veya küçük olmalý,1 e eþit veya büyük olmalýdýr.");
    		}
    	}
    	
        return 0;
    }
    //Kayan Pencere ve Maksimum deðer hesabýnýn yapýldýðý fonksiyon
    //Öz yinelemeli fonksiyon
    public int WindowMaxCalc(int[] nums,int k,int len,int g) {
    	if(k<=len) {
    		int maxdeger=nums[g];
    		for(int j=g;j<k+g;j++) {
    			if(maxdeger<nums[j]) {
    				maxdeger = nums[j];
    			}
    		}
    		System.out.print(maxdeger+" ");
    	}else {
    		System.out.println();
    		System.exit(0);
    	}
    	return WindowMaxCalc(nums,k,len-1,g+1);
    }
    public static void main(String[] args) {
    	BitesProje func = new BitesProje(); 
    	int [] nums = {1,3,-1,-3,5,3,6,7};
    	int k=3;
    	func.getSolution(nums,k);	
    }
}
