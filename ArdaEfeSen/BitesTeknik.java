package bitesTeknik;

import java.util.ArrayList;
import java.util.Scanner;


					// Arda Efe �EN



public class BitesTeknik implements MaxNumberInterface,RightToBinaryTree,Sqrt{
	
	public static void main(String[] args) {
	
		
		
		//soru1();
		//soru2();
		
		//soru3();
	}
	
	public static void soru1() {
		System.out.println("L�tfen girece�iniz eleman say�s�n� giriniz: ");
		Scanner sc = new Scanner(System.in);
		int arrNum = sc.nextInt();                                     // Girilecek eleman say�s�n�n kullan�c�dan al�nmas�
		ArrayList <Integer> numsList = new ArrayList<Integer>();
		
		for(int i=0; i<arrNum; i++) {
			
			System.out.print("L�tfen array elemanlar�n� giriniz: ");   // Arraylist'e assign edilmesi
			int element = sc.nextInt();
			numsList.add(element);
			
		}
		
		int[] nums = numsList.stream().mapToInt(i -> i).toArray();   // Arraylist'in Array'e �evrilmesi
		System.out.print("L�tfen k eleman�n� giriniz: ");
		int k = sc.nextInt();										// K de�erinin kullan�c�dan al�nmas�
		MaxNumberInterface max = new BitesTeknik();
		int [] solution = max.getSolution(nums, k);					// Solution fonksiyonun �a�r�lmas�
		
		if(solution == null) {
			System.out.println("k eleman� array boyutundan b�y�k olamaz"); // k de�eri kontrol�
		}
		
		else {
			System.out.print("Max: [ ");
			for(int i = 0; i<solution.length;i++) {
				System.out.print(solution[i] + ",");		// yeni gelen array'in yazd�r�lmas�
			}
			System.out.println(" ]");
			
			
		}	
	 
	}
	
	public static void print(Node root) {
		
	     
	      if (root == null) {

	    	  System.out.print(" #");
	    	  												// A�ac�n nodelar�n�n yazd�r�lmas�
	      }
	      else {
	    	  System.out.print(" " + root.val);
	    
	    	 print(root.next); 
	      }
		
		
		
	}
	public static void soru2() {
		
		Node root = new Node();
		

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);				//Binary Tree'nin doldurulmas�
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        
        
         RightToBinaryTree right = new BitesTeknik();
        


         right.connect(root);					// connect metodunun �a��rlmas�
         print(root);
         print(root.left);						// level wise a�ac�n yazd�r�lmas�
         print(root.left.left);
         
   

        
		 
	}
	
	public static void soru3() {
		System.out.print("L�tfen karek�k� al�nacak say�y� giriniz :");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();							// Kullanc�dan say� al�nmas�.
		Sqrt sqrt = new BitesTeknik();
		System.out.println(sqrt.getSolution(x));
		
	}

	@Override
	public int[] getSolution(int[] nums, int k) {
		ArrayList <Integer> solutionList = new ArrayList<Integer>();
		int max = nums[0];
		
		if(k> nums.length) {
			return null;
		}
		
		for(int i = 0; i<nums.length-k+1;i++) {
			for(int j = i; j<k+i; j++) {
				if(nums[j]>max) {					// Gelen arrayde maximum kontrol� yap�lmas�
					max = nums[j];
					
				}
				
			}
			
			solutionList.add(max);				// Maksimum say�lar�n arraylist'e aktar�lmas�
					
		}
		
		
		int[] solution = solutionList.stream().mapToInt(i -> i).toArray(); // Array'in arrayliste �evrilmesi
		
		
		return solution;		// Max array'in d�nd�r�lmesi
	}
	
	
	@Override
	public Node connect(Node root) {
		
		
		if (root==null)
			return null;
		
		Node headNode = root;
		
		while(headNode!=null) {
			Node dummyNode = new Node(0);		// Ana A�a�tan ba��ms�z bir dummy node olu�turulmas�
			Node temp = dummyNode;				// dummy d���m� her yeni levele ge�ildi�inde olu�turulur ve
												// ana d���m�n update'i i�in olu�turulur.
			while(headNode!=null) {					
													
				if(headNode.left!=null) {		  // Ana d���mden ba�layarak level order 
					temp.next = headNode.left;    //traversal y�ntemiyle a�ac�n gezilmesi
					temp = temp.next;
					
				}
				if(headNode.right!=null) {
					temp.next = headNode.right;
					temp = temp.next;
					
				}
				headNode = headNode.next;
				
				
				
			}
			
			headNode = dummyNode.next;       // root node'un update'i
			
			
		}
		
		
		return headNode;
		
		
		
		
	
	}

	@Override
	public int getSolution(int x) {
		double temp;
		double sqrt = x;			
		
		do {
			temp = sqrt;
			System.out.println(sqrt);
			sqrt = (temp + (x/temp))/2;      // temp de�eri, sqrt de�erinin bir �nceki halini tutar.
											 //ikisi aras�ndaki fark 0 olana dek expression'� d�nd�r�r.
			
		}while((temp-sqrt)!=0);
	

		
		return (int)sqrt;
		

		// TODO Auto-generated method stub
		
	}

	
	
		
		
}


