class Question2 implements RightToBinaryTree {

    @Override
    public Node connect(Node root) {

        Node node = root;
        /* base case node null control */
        while (node != null) {
            Node dummy = new Node();
            Node tmp = dummy;
            // build the linkedList
            while (node != null) {
                if (node.left != null) {
                    tmp.next = node.left;
                    tmp = tmp.next;
                }
                if (node.right != null) {
                    tmp.next = node.right;
                    tmp = tmp.next;
                }

                node = node.next;
            }
            /* go next level */
            node = dummy.next;
        }

        return root;

    }
}

interface RightToBinaryTree {
    public Node connect(Node root);
}

/* Definition for a Node. */
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
