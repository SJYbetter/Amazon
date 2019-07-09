package Tree;

import DS.TreeNode;

/*Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3

*/
public class MaximumDepthofBinaryTree{


//using the divide and conquer
public int maxDepth(TreeNode root){
    if (root == null) return 0;
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return Math.max(left, right) + 1;
}


//using traverse
private int depth;
public int maxDepth1(TreeNode root){
    depth = 0;
    traverse(root, 1);
    return depth;
}

private void traverse(TreeNode node, int curDepth){
    if (node == null) return;
    depth = Math.max(curDepth, depth);
    traverse(node.left, curDepth + 1);
    traverse(node.right, curDepth + 1);
}

}
