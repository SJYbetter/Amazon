package Tree;
import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;





public class ValidBST {

//F1 : inorder traverse return a none descending list
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		helper(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) >= list.get(i))
				return false;
		}
		return true;
	}

	private void helper(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		helper(node.left, list);
		list.add(node.val);
		helper(node.right, list);
	}

//F2 iteration
	public boolean isValidBST2(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}
		return true;
	}
}


