package src;

public class RightToBinaryTreeImpl implements RightToBinaryTree {

    @Override
    public Node connect(Node root){

        if (root == null) {
            return null;
        }

        Node tempHead = root;

        while (tempHead != null) {

            Node empty = new Node();
            Node temp = empty;

            while (tempHead != null) {
                if (tempHead.left != null){
                    temp.next = tempHead.left;
                    temp = temp.next;
                }
                if (tempHead.right != null){
                    temp.next = tempHead.right;
                    temp = temp.next;
                }
                tempHead = tempHead.next;

            }

            tempHead = empty.next;

        }

        return root;
    }


}
