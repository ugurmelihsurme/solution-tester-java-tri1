package com.hakan.toprak.model;

public class BinaryTree implements RightToBinaryTree{

	@Override
	public Node connect(Node root) {
		 int h = height(root);
	        int i;
	        for (i = 1; i <= h; i++) {
	            connectCurrentLevel(root, i);
	            System.out.print("#");
	        }
			return root;
	}
	 static int height(Node root)
	    {
	        if (root == null)
	            return 0;
	        else {
	            /* compute  height of each subtree */
	            int lheight = height(root.left);
	            int rheight = height(root.right);
	 
	            /* use the larger one */
	            if (lheight > rheight)
	                return (lheight + 1);
	            else
	                return (rheight + 1);
	        }
	    }
	    static void connectCurrentLevel(Node root, int level)
	    {
	        if (root == null)
	            return;
	        if (level == 1 && root.val!=0)
	            System.out.print(root.val + " ");
	        else if (level > 1) {
	        	connectCurrentLevel(root.left, level - 1);
	        	connectCurrentLevel(root.right, level - 1);
	        }
	    }

}
