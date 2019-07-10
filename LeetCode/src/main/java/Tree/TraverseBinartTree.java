package Tree;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TraverseBinartTree{
	
    public List<Integer> preOrderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, ans);
        return ans;
    }
    
    private void helper(TreeNode node, List<Integer> ans){
        if (node == null) return;
        ans.add(node.val);
        helper(node.left, ans);
        helper(node.right, ans);
    }


    public List<Integer> inOrderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        helper1(root, ans);
        return ans;
    }

    private void helper1( TreeNode node, List<Integer> list){
        if (node == null) return;
        helper1(node.left, list);
        list.add(node.val);
        helper1(node.right, list);
    }
}
