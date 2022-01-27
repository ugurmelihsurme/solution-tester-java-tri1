package functions;

import interfaces.RightToBinaryTree;

public class Tree implements RightToBinaryTree {

    public Node root;

    @Override
    public Node connect(Node root) {
        if (root == null) return null;


        Node rightNode = root.right;
        Node leftNode = root.left;
        Node nextNode = root.next;

        if (leftNode != null) {
            leftNode.next = root.right;
            connect(leftNode);
        }

        if (rightNode != null) {
            if (nextNode != null) {
                rightNode.next = nextNode.left;
            } else {
                rightNode.next = null;
            }
            connect(rightNode);
        }
        return root;
    }
}
