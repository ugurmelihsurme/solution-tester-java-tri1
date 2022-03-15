/**
* // Definition for a Node.
* function Node(val, left, right, next) {
* this.val = val === undefined ? null : val;
* this.left = left === undefined ? null : left;
* this.right = right === undefined ? null : right;
* this.next = next === undefined ? null : next;
* };
*/
/**
* @param {Node} root
* @return {Node}
*/
  function Node(val, left, right, next) {
 this.val = val === undefined ? null : val;
 this.left = left === undefined ? null : left;
 this.right = right === undefined ? null : right;
 this.next = next === undefined ? null : next;
};
   var connect = function (root) {
        if (!root) {
            return null;
        }
        if (root.next && root.right) {
            root.next.left ? root.right.next = root.next.left : root.right.next = root.next.right;
        }
        if (root.left && root.right) {
            root.left.next = root.right;
        }
        connect(root.left);
        connect(root.right);
        return root;
    };
    var root = new Node(1);
    root.left = new Node(2);
    root.left.right = new Node(5);
    root.right = new Node(3);
    root.right.left = null;
    root.left.left = new Node(4);
    root.right.right = new Node(7);

