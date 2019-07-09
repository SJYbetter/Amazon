package LinkedList;

import DS.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    public void flattern(TreeNode root){
        if (root == null) return;
        flattern(root.left);
        flattern(root.right);
        if (root.left == null) return;

        TreeNode node = root.left;
        while (node.right != null){
            node = node.right;
        }
        node.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
