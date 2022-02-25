
public class Soru2 implements RightToBinaryTree {

	@Override
	public Node connect(Node root) {
		// TODO Auto-generated method stub
		
		if(root == null) {
			return null;
		}

		if(!(root.left == null) && !(root.right == null)) {
			root.left.next = root.right;
			root.right.next = connect(root.next);
			connect(root.left);
			connect(root.right);
			 return (root.left);
		}
		else if((root.left == null) && !(root.right == null)) {
			root.right.next = connect(root.next);
			connect(root.right);
			return (root.right);
		}
		else if(!(root.left == null) && (root.right == null)) {
			root.left.next = connect(root.next);
			connect(root.left);
			return (root.left);
		}
		else {
		
			return null;
		}
		
	}
	
}
