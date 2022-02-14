/*Soru 1 Cevap Kodlama - NURAY YILDIZLI*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
interface MaxNumberInterface{
	 public int getSolution(int[] nums, int k); 
}

public class BitesProje implements MaxNumberInterface{
    @Override
    //Girilen parametrelerin kural kontrol�
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
    		System.out.println("Dizi uzunlu�u 1 den b�y�k 105 den k���k olmal�d�r.");
    	}
    	
    	if(arrayControl>0) {
    		System.out.println("Dizi de�erleri -104 den k���k ve 104 den b�y�k olamaz! Girmi� oldu�unuz de�erleri kontrol ediniz!");
    	}else {
    		if(k>=1 && k<=nums.length) {
    			int g = 0;
    			obje.WindowMaxCalc(nums,k,nums.length,g);
    		}else {
    			System.out.println("k de�eriniz hatal� kontrol ediniz!Girmi� oldu�unuz k de�eri dizi boyutuna e�it veya k���k olmal�,1 e e�it veya b�y�k olmal�d�r.");
    		}
    	}
    	
        return 0;
    }
    //Kayan Pencere ve Maksimum de�er hesab�n�n yap�ld��� fonksiyon
    //�z yinelemeli fonksiyon
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
