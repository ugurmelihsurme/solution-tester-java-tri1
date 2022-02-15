import java.util.*;

interface RightToBinaryTree{
    public Node connect(Node root);
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
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

class RightToBinaryTreeImpl implements RightToBinaryTree{

    @Override
    public Node connect(Node root) {

        int controlValue = 0;
        if(root == null){
            return null;
        }

        int nodeSize = size(root);
        if (nodeSize>0 && nodeSize<=6000){
            Map<Integer, List<Integer>> map = new HashMap<>();

            preorder(root, 1, map);
            int valueNode = controlValue(map);

            if (valueNode>0){
                return null;
            }else{

                printPreOrder(map);
            }
        }

        return root;
    }

    public void preorder(Node root, int level, Map<Integer, List<Integer>> map)
    {
        if (root == null) {
            return;
        }

        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);

        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }

    public void printPreOrder(Map<Integer, List<Integer>> map){
        for (int i = 1; i <= map.size(); i++) {
            for (int j=0; j<map.get(i).size(); j++){
                System.out.print(map.get(i).get(j) + ",");
            }
            System.out.print("#");
            if (i!=map.size()){
                System.out.print(",");
            }
        }
    }

    public int size(Node node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }

    public int controlValue(Map<Integer, List<Integer>> map){

        int controlValue = 0;

        for (int i = 1; i <= map.size(); i++) {
            for (int j=0; j<map.get(i).size(); j++){

                if(map.get(i).get(j)<=-100 || map.get(i).get(j)>=100){
                    controlValue++;
                }
            }
        }
        return controlValue;
    }
}
