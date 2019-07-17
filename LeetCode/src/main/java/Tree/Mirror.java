package Tree;

import DS.TreeNode;

public class Mirror {

	public static boolean isMirror(TreeNode root) {
		if (root == null) return true;
		return help(root.left, root.right);
	}
	
	private static boolean help(TreeNode p, TreeNode q) {
		//p and q are all leaves return true
		if (p == null && q == null) return true;
		// p or q is null due to not balance
		if (p == null || q == null) return false;
		// only when value are same and child leaves are same
		return help(p.left, q.right) && help(p.right, q.left) && p.val == q.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
