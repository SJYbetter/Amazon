/*
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

*/



class Solution {
    public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<>();
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);
             root = root.left;
         }
         root = stack.pop();
         if(--k == 0) break;
         root = root.right;
     }
     return root.val;
    }

    //using inorder traverse 
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);

    }

    private void inorder(TreeNode root, List<Integer> list){
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
