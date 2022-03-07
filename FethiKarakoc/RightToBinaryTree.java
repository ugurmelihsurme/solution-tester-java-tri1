package bitesSoru2;

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

public interface RightToBinaryTree {
	public Node connect(Node root);
}

class Challange implements RightToBinaryTree{
	
	private Node getNextNode(Node root) {
		
		if(root == null || root.next == null) return null;
		
		if(root.next.left != null) return root.next.left;
		
		if(root.next.right != null) return root.next.right;
		
		return getNextNode(root);
	}
	
	@Override
	public Node connect(Node root) {
				
		if(root == null) return null;			
		
		connect(root.next);
		
		if(root.left != null) {			
			root.left.next = (root.right != null) ? root.right : getNextNode(root);
		} 
		if(root.right != null) {
			root.right.next = getNextNode(root);
		}
		
		connect(root.left);
		connect(root.right);
		
		return root;
	}
}

