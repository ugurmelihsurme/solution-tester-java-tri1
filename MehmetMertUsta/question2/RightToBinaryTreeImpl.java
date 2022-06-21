package mmert.usta.question2;

public class RightToBinaryTreeImpl implements  RightToBinaryTree{
    @Override
    public Node connect(Node root) {
        if(root == null ) return null;

        
        //   O
        //  /
        // 1
        if(root.left != null)
        {
            root.left.next = root.right;
        }
        
        //   1
        //  / \
        // 2   3
        if (root.right != null && root.next != null)
        {
        	 //      1
            //    /    \
            //   2      3
        	//  / \       \
        	// 4   5- next->7
            if(root.next.left == null && root.next.right != null)
                root.right.next = root.next.right;
            else
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}
