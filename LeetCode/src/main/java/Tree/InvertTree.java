import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertTree {
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}
	
	public static void bfs(TreeNode root){
		//TreeNode ans = invertTree(root);
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		List<List<Integer>> res = new ArrayList<>();
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode head = q.poll();
				level.add(head.val);
				if (head.left != null) {
					q.offer(head.left);
				}
				if (head.right != null) {
					q.offer(head.right);
				}
			}
			res.add(level);
			System.out.println("level" + level);
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode node1_1 = root.left = new TreeNode(1);
		TreeNode node1_2 = root.right = new TreeNode(2);
		TreeNode node2_1 = node1_1.left = new TreeNode(3);
		TreeNode node2_2 = node1_1.right = new TreeNode(4);
		TreeNode node2_3 = node1_2.left = new TreeNode(5);
		TreeNode node2_4 = node1_2.right = new TreeNode(6);
		
		TreeNode ans = invertTree(root);
		bfs(ans);		

	}

}
