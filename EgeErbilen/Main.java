import java.util.*;


// Soru 1
interface MaxNumberInterface {
    public int[] getSolution(int[] nums, int k);
}

class MaxValue implements MaxNumberInterface {

    @Override
    public int[] getSolution(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans[] = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if ((i - k + 1) >= 0 && i < nums.length) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }

        }
        return ans;
    }

}
// ----- Soru 1 Son -----



// Soru 2
interface RightToBinaryTree {
    public Node connect(Node root);
}

class ConnectTree implements RightToBinaryTree{
    @Override
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node prev = temp;
                temp = q.poll();

                if (i > 0)
                    prev.next = temp;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
            temp.next = null;
        }
        return root;
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
};

// ----- Soru 2 Son -----



// Soru 3
interface Sqrt {
    public int getSolution(int x);
}

class Calculate implements Sqrt {

    @Override
    public int getSolution(int x) {
        if (x >= 0 && x <= 230) {
            //sqrt(n+1)=(sqrt(n)+(num/sqrt(n)))/2.0
            double n;
            double squareRoot = x / 2.0;
            do {
                n = squareRoot;
                squareRoot = (n + (x / n)) / 2;
            } while ((n - squareRoot) != 0);

            return (int) squareRoot;
        } else {
            return -1;
        }
    }
}
// ----- Soru 3 Son -----




public class Main {

    public static void main(String[] args) {
        // Soru 1
        MaxValue max = new MaxValue();
        int[] nums= {1,3,-1,-3,5,3,6,7};

        int[] result= max.getSolution(nums, 3);

//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i]+", ");
//        }
        // ----- Soru 1 Son -----


        //Soru 2
        Node root = new Node();
//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.right = new Node(7);
        ConnectTree connectTree = new ConnectTree();
        connectTree.connect(root);


        // ----- Soru 2 Son -----

        //Soru 3
        Calculate cal = new Calculate();
//        System.out.println(cal.getSolution(8));
        // ----- Soru 3 Son -----
    }

}

