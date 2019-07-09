package Tree;

import DS.TreeNode;

public class MaxDepth {
    //divide and conquer => recursion
    private static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }


    //traverse way => recursion
    private static int depth=0;
    private static int maxDepth_2(TreeNode root){
        traverse(root, 1);
        return depth;
    }
    private static void traverse(TreeNode node, int curdepth){
        if (node == null) return;
        traverse(node.left, curdepth+1);
        traverse(node.right, curdepth+1);
        depth = Math.max(depth, curdepth);
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = node1.left = new TreeNode(2);
        TreeNode node3 = node1.right = new TreeNode(3);

        TreeNode node4 = node2.left = new TreeNode(4);

        System.out.println(maxDepth(node1));
        System.out.println(maxDepth_2(node1));
    }
}
