/*
 * Copyright (c) 2021. Licenced to BTK  ATP Project
 */
package bites;

/**
 * @author : gulsen.ozcan
 * @createdAt : 21.01.2022
 **/


interface RightToBinaryTree {
    public Node connect(Node root);
}

public class RightToBinaryTreeImpl implements RightToBinaryTree {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = findNext(root);
            }
        } else if (root.left == null && root.right != null) {
            if (root.next != null) {
                root.right.next = findNext(root);
            }
        } else {
            if (root.next != null && root.left != null) {
                root.left.next = findNext(root);
            }
        }

        connect(root.right);
        connect(root.left);

        return root;
    }


    private Node findNext(Node root) {
        if (root == null || root.next == null) {
            return null;
        }

        if (root.next.left != null) {
            return root.next.left;
        }

        if (root.next.right != null) {
            return root.next.right;
        }

        return findNext(root.next.next);
    }

}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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
