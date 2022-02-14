/*Soru 2 Cevap Kodlama- NURAY YILDIZLI*/
import java.util.Scanner;
public class BinaryTree {
	public static class Node {
		
		 public int val;
		 public Node left;
		 public Node right;
		 public Node next;
		 public Node() {}
		 
		 public Node(int _val) {
		 val = _val;
		 }
		 public Node(int _val, Node _left, Node _right, Node _next) {
		 val = _val;
		 left = _left;
		 right = _right;
		 next = _next;
		 }
	
	}
	//öz yinelemeli fonksiyon
	public Node provideSiblings(Node root) {
		if (root != null) {

			if (root.left != null) { // sol düðüm boþ deðilse
				// sol düðümün kardeþlerini kökün sað düðümü yap
				root.left.next = root.right;
			}
			if (root.right != null) {// sað düðüm boþ deðilse
				if (root.next != null)// root herhangi bir kardeþi olup olmadýðýna bakýlýyor
					// sað düðümün kardeþlerini sonraki kökün kardeþleri yap
					// sol node
					root.right.next = root.next.left;
			}
			provideSiblings(root.left);
			provideSiblings(root.right);
			return root; 

		}
		return null;
	}

	public void printLevel(Node n) {
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
        System.out.print("#");
	}

	public static void main(String[] args) {
		/*int n;
		Scanner in = new Scanner(System.in);
		System.out.print("Dizi boyutunu giriniz");  
		//reading the number of elements from the that we want to enter  
		n=in.nextInt();  
		//creates an array in the memory of length 10  
		int[] array = new int[10];  
		System.out.println("Dizi elemanlarýný giriniz: "); 
		if(n>0 && n<6000) {
			System.out.println("Girmiþ olduðunuz boyut deðeri 0 ile 6000 arasýnda olmalýdýr!");
		}else {
			for(int i=0; i<n; i++){
				if(in.nextInt()>-100 && in.nextInt()<100) {
					System.out.println("Girmiþ olduðunuz deðer -100 ile 100 arasýnda olmalýdýr!");
					System.exit(0);
				}else {
					array[i]=in.nextInt();  
				}
				
			}
		}*/
		
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(7);
		//root.right.right = new Node(7);

		BinaryTree i = new BinaryTree();
		Node x = i.provideSiblings(root);
		i.printLevel(x);
		i.printLevel(x.left);
		i.printLevel(x.left.left);
		//output = 1#23#457#
	}
    
}
