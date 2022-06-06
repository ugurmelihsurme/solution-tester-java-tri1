import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTree implements RightToBinaryTree
{	
	 Node root;
	 static List<String>list=new ArrayList<String>();
	 @Override
	 public Node connect(Node first, int k) 
	    {
	        if (first == null)
	            return null;
	        Queue<Node> qn = new LinkedList<Node>(); 

	        Queue<Integer> ql = new LinkedList<Integer>();   
	        int level = 0; 
	        qn.add(first);
	        ql.add(level);

	        while (qn.size() != 0) 
	        {
	            Node node = qn.peek();
	            level = ql.peek();
	            qn.remove();
	            ql.remove();
	            if (node.data == k) 
	            {
	                if (ql.size() == 0 || ql.peek() != level)
	                    return null;
	                return qn.peek();
	            }
	            if (node.left != null) 
	            {
	                qn.add(node.left);
	                ql.add(level + 1);

	            }
	            if (node.right != null) 
	            {
	                qn.add(node.right);
	                ql.add(level + 1);
	            }
	        }
	        return null;
	    }
	 
	 void findNode(Node node, int k) 
	    {
	        Node nr = connect(root, k);
	        if (nr != null) {
	            list.add(new Integer(k).toString());
	            list.add(new Integer(nr.data).toString());
	        }
	        else {
	            list.add(new Integer(k).toString());
	            list.add("#");
	        }
	    }
	 public static List<String> removeDuplicates(List<String> list)
	    {
	        List<String> newList = new ArrayList<String>();
	        for (String element : list) {
	        	if (element.equals("#")) {
	                newList.add(element);
	            }
	        	if (!newList.contains(element)) {
	                newList.add(element);
	            }
	        }
	        return newList;
	    }

	 public static void main(String args[]) 
	    {
	        BinaryTree tree = new BinaryTree();

	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.right.right = new Node(7);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        
	        
	        tree.findNode(tree.root, 1);
	        tree.findNode(tree.root, 2);
	        tree.findNode(tree.root, 3);
	        tree.findNode(tree.root, 4);
	        tree.findNode(tree.root, 5);
	        tree.findNode(tree.root, 7);
	        List<String>resultList=removeDuplicates(list);
	        System.out.print(resultList);
	    }
}
