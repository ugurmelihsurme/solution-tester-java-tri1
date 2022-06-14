var connect = function (root) {

  if (!root) return null;
  let current = root;
  let leftMostChild = null;
  
  while (current.left) {
    leftMostChild = current.left;
    while (current) {
    
      current.left.next = current.right;
      current.right.next = current.next ? current.next.left : null;
      current = current.next;
    }
    current = leftMostChild;
  }

  return root;
};
