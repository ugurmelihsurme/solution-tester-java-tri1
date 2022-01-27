import functions.Tree;
import interfaces.RightToBinaryTree;

public class MainTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new RightToBinaryTree.Node(1);
        tree.root.left = new RightToBinaryTree.Node(2);
        tree.root.right = new RightToBinaryTree.Node(3);
        tree.root.left.left = new RightToBinaryTree.Node(4);
        tree.root.left.right = new RightToBinaryTree.Node(5);
        tree.root.right.right = new RightToBinaryTree.Node(7);

        tree.connect(tree.root);

    }
}
