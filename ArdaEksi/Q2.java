

public class Q2 implements RightToBinaryTree{

	
	public Node connect(Node root)
	{
		if(root == null)
		{
			return root;
		}
		Node temp = root;
		connectRight(temp);
		return temp;

	}
	
	
	private void connectRight(Node root)
	{	
		Node temp = root.next;
		while((temp != null) && temp.left == null && temp.right == null)
		{
			temp = temp.next;
		}
		Node select =  temp != null ? (temp.left != null ? temp.left : temp.right) : null;
		if(root.right != null)
		{
			root.right.next = select; 
		}
		if(root.left != null)
		{
			root.left.next = root.right != null ? root.right : select;	
		}
		if(root.right != null)
		{
			connectRight(root.right);
		}
		if(root.left != null)
		{
			connectRight(root.left);		
		}	
	}		
}
class Node {
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
