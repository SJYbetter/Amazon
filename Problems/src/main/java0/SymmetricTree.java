public class SymmetricTree{
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			this.val = x;
		}
		
	}
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q){
        //no leaves
        if (p == null && q == null) return true;
        //not balance
        if (p == null || q == null) return false;
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
