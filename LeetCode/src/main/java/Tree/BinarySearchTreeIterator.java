package Tree;

import DS.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root){
        stack = new Stack<TreeNode>();
        lefty(root);
    }

    public int next(TreeNode root){
        TreeNode head = stack.pop();
        if (head.right != null){
            lefty(head.right);
        }
        return head.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    private void lefty(TreeNode node){
        if (node == null) return;
        while (node != null){
            stack.push(node.left);
            node = node.left;
        }
    }
}
