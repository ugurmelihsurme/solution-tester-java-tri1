package com.bites;

public class Main {

    public static void main(String[] args) {
        RightToBinaryTreeImpl rightToBinaryTree = new RightToBinaryTreeImpl();
        rightToBinaryTree.connect(new Node());
    }
}

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

class RightToBinaryTreeImpl implements RightToBinaryTree {

    @Override
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node node = root.next;
        Node nextNode = null;

        while (node != null) {
            if (node.left != null) {
                nextNode = node.left;
                break;
            }
            if (node.right != null) {
                nextNode = node.right;
                break;
            }

            node = node.next;
        }

        if (root.right != null)
            root.right.next = nextNode;
        if (root.left != null)
            root.left.next = root.right == null ? nextNode : root.right;

        connect(root.right);
        connect(root.left);

        return root;
    }
}

interface RightToBinaryTree {
    public Node connect(Node root);
}
