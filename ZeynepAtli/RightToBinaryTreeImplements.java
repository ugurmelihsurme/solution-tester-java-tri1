package bites;


public class RightToBinaryTreeImplements implements RightToBinaryTree {

	@Override
	public Node connect(Node root) {
		if (root == null) {
			 return null; 
		 }           
		return getResult(root);
	}
	
	private Node getResult(Node root) {
		
        Node headNode =root;
        while(headNode != null){
            Node newNode = new Node(0);
            Node tempNode = headNode;
             while(headNode != null){
                if(headNode.left != null){
                    tempNode.next = headNode.left;
                    tempNode = tempNode.next;
                }
                 
                if(headNode.right != null){
                    tempNode.next = headNode.right;
                    tempNode = tempNode.next;
                }
                headNode = headNode.next;
             }
            headNode = newNode.next;
        }
      return root;
}

}
