package Tree;

import DS.TreeNode;

public class MinDepthOfBinaryTree{

    private int miniDepth(TreeNode root){
        if (root == null) return 0;
        int left = miniDepth(root.left);
        int right = miniDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    private int maxDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
}
