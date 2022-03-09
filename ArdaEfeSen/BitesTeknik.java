package bitesTeknik;

import java.util.ArrayList;
import java.util.Scanner;


					// Arda Efe ÞEN



public class BitesTeknik implements MaxNumberInterface,RightToBinaryTree,Sqrt{
	
	public static void main(String[] args) {
	
		
		
		//soru1();
		//soru2();
		
		//soru3();
	}
	
	public static void soru1() {
		System.out.println("Lütfen gireceðiniz eleman sayýsýný giriniz: ");
		Scanner sc = new Scanner(System.in);
		int arrNum = sc.nextInt();                                     // Girilecek eleman sayýsýnýn kullanýcýdan alýnmasý
		ArrayList <Integer> numsList = new ArrayList<Integer>();
		
		for(int i=0; i<arrNum; i++) {
			
			System.out.print("Lütfen array elemanlarýný giriniz: ");   // Arraylist'e assign edilmesi
			int element = sc.nextInt();
			numsList.add(element);
			
		}
		
		int[] nums = numsList.stream().mapToInt(i -> i).toArray();   // Arraylist'in Array'e çevrilmesi
		System.out.print("Lütfen k elemanýný giriniz: ");
		int k = sc.nextInt();										// K deðerinin kullanýcýdan alýnmasý
		MaxNumberInterface max = new BitesTeknik();
		int [] solution = max.getSolution(nums, k);					// Solution fonksiyonun çaðrýlmasý
		
		if(solution == null) {
			System.out.println("k elemaný array boyutundan büyük olamaz"); // k deðeri kontrolü
		}
		
		else {
			System.out.print("Max: [ ");
			for(int i = 0; i<solution.length;i++) {
				System.out.print(solution[i] + ",");		// yeni gelen array'in yazdýrýlmasý
			}
			System.out.println(" ]");
			
			
		}	
	 
	}
	
	public static void print(Node root) {
		
	     
	      if (root == null) {

	    	  System.out.print(" #");
	    	  												// Aðacýn nodelarýnýn yazdýrýlmasý
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
        root.left.left = new Node(4);				//Binary Tree'nin doldurulmasý
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(7);
        
        
         RightToBinaryTree right = new BitesTeknik();
        


         right.connect(root);					// connect metodunun çaðýrlmasý
         print(root);
         print(root.left);						// level wise aðacýn yazdýrýlmasý
         print(root.left.left);
         
   

        
		 
	}
	
	public static void soru3() {
		System.out.print("Lütfen karekökü alýnacak sayýyý giriniz :");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();							// Kullancýdan sayý alýnmasý.
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
				if(nums[j]>max) {					// Gelen arrayde maximum kontrolü yapýlmasý
					max = nums[j];
					
				}
				
			}
			
			solutionList.add(max);				// Maksimum sayýlarýn arraylist'e aktarýlmasý
					
		}
		
		
		int[] solution = solutionList.stream().mapToInt(i -> i).toArray(); // Array'in arrayliste çevrilmesi
		
		
		return solution;		// Max array'in döndürülmesi
	}
	
	
	@Override
	public Node connect(Node root) {
		
		
		if (root==null)
			return null;
		
		Node headNode = root;
		
		while(headNode!=null) {
			Node dummyNode = new Node(0);		// Ana Aðaçtan baðýmsýz bir dummy node oluþturulmasý
			Node temp = dummyNode;				// dummy düðümü her yeni levele geçildiðinde oluþturulur ve
												// ana düðümün update'i için oluþturulur.
			while(headNode!=null) {					
													
				if(headNode.left!=null) {		  // Ana düðümden baþlayarak level order 
					temp.next = headNode.left;    //traversal yöntemiyle aðacýn gezilmesi
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
			sqrt = (temp + (x/temp))/2;      // temp deðeri, sqrt deðerinin bir önceki halini tutar.
											 //ikisi arasýndaki fark 0 olana dek expression'ý döndürür.
			
		}while((temp-sqrt)!=0);
	

		
		return (int)sqrt;
		

		// TODO Auto-generated method stub
		
	}

	
	
		
		
}


