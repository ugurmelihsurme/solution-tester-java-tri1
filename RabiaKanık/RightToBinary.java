/*
SORU2 : BINARY TREE
Rabia Kanık
 */

//Arayüz
public interface RightToBinary {
    public Node connect(Node root);
}

class Node{
    public int val;
    public Node left;
    public Node right;
    public Node next;

       // public Node(){}
    public Node(int_val){
        val=_val;
    }

    public Node(int_val, Node_left, Node_right, Node_next){
        val=_val;
        left= _left;
        right= _right;
        next= _next;
    }
};

//Çözüm Algoritması
class Solution{
    public Node connect(Node root){
        if (root==null)
            return null;
        Node head= root;

        while(head != null){
            Node dummy = new Node();
            Node temp = dummy;

            while(head != null){
                if (head.left != null){
                    temp.next= head.left;
                    temp= temp.next;
                }
                if(head.right != null){
                    temp.next = head.right;
                    temp=temp.next;
                }
                head = head.next;
            }
            head=dummy.next;
        }
        return root;
    }
}









