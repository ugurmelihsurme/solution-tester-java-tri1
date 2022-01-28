package bites;

public class RightToBinaryTreeImplementation implements RightToBinaryTree{

    public static Node result;
    public static Node treeLevel;
    public static boolean isTreeLevelFirstNode = true;
    public static boolean isResultFirstNode = true;

    public Node connect(Node root) {
        int height = calculateHeight(root);
        for (int i = 1; i <= height; i++) {
            treeLevel = new Node();
            isTreeLevelFirstNode = true;
            connectNode(root, i);
            if (result == null) {
                result = new Node();
            }
            insertTreeLevel(result, treeLevel);
        }
        return result;
    }

    public void connectNode(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            insert(treeLevel, root.val);
        } else if (level > 1) {
            connectNode(root.left, level - 1);
            connectNode(root.right, level - 1);
        }
    }

    public Node insert(Node node, int newData) {

        int nodeCount = countNode(result) + countNode(treeLevel);

        if ((nodeCount < 6000 && nodeCount > 0) && (newData > -100 && newData < 100)) {
            if (node == null) {
                node = new Node(newData);
                return node;
            }
            if (isTreeLevelFirstNode) {
                node.val = newData;
                isTreeLevelFirstNode = false;
            } else {
                node.right = insert(node.right, newData);
            }
        }
        return node;
    }

    public Node insertTreeLevel(Node root, Node treeLevel) {
        if (root == null) {
            root = treeLevel;
            return root;
        }
        if (isResultFirstNode) {
            result = treeLevel;
            isResultFirstNode = false;
        } else {
            root.next = insertTreeLevel(root.next, treeLevel);
        }
        return root;
    }

    public int calculateHeight(Node root) {
        if (root == null)
            return 0;
        else {
            int left = calculateHeight(root.left);
            int right = calculateHeight(root.right);
            if (left > right)
                return (left + 1);
            else
                return (right + 1);
        }
    }

    public int countNode(Node root) {
        if (root == null)
            return 0;
        return 1 + countNode(root.left) + countNode(root.right) + countNode(root.next);
    }

    public class Node {
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

    ;
}
