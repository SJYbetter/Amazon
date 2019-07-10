package Tree;

import DS.TreeNode;

public class LCAofBinaryTree{
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root ==  null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p and q are in two sides
        if (left != null && right != null) return root;
        //p and q are in one side
        return left != null ? left : right;
    }
}
