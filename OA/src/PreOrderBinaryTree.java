public class PreOrder{
    public List<Integer> preOrderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;
        helper(root, ans);
        return ans;
    }

    private void helper(TreeNode node, ArrayList<Integer> ans){
        if (node == null) return;
        ans.add(node.val);
        helper(node.left);
        helper(node.right);
    }
}
