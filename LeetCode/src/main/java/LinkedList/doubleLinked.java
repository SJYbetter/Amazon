package LinkedList;

import java.util.*;



class doubleLinked {
	public static class TreeNode {
		int val;
		TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

	public static class ListNode {
		int val;
		ListNode prev, next;
		public ListNode(int val) {
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}

	public static boolean TreeToList(TreeNode root, TreeNode p, ListNode tail) {

		if (root == null) {
			return false;
		}

		tail.next = new ListNode(root.val);
		tail.next.prev = tail;

		if (root.val == p.val) {
			return true;
		}

		if (TreeToList(root.left, p, tail.next)) {
			return true;
		}
		if (TreeToList(root.right, p, tail.next)) {
			return true;
		}
		
		tail.next = null;
		return false;
	}

	public static void LeafList(TreeNode root, ListNode tail) {
		if (root == null) {
			return;
		}
        //find the leaf
		if (root.left == null && root.right == null) {
			while (tail.next != null) {
				tail = tail.next;
			}

			tail.next = new ListNode(root.val);
			tail.next.prev = tail;
			return;
		}

		if (root.left != null) {
			LeafList(root.left, tail);
		}

		if (root.right != null) {
			LeafList(root.right, tail);
		}
	}

	private static void printDlist(ListNode dummy) {
		ListNode tail = dummy;
		while (tail.next != null) {
			tail = tail.next;
			System.out.print(tail.val + "->");
		}
		System.out.print("\n");
		System.out.print(tail.val + "->");
		while (tail.prev != dummy) {
			tail = tail.prev;
			System.out.print(tail.val + "->");
		}
		System.out.print("\n");
	}

	private static void printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur == null) {
					System.out.print(". ");
					continue;
				}
				System.out.print(cur.val + " ");
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		TreeNode cur = root.left;
		cur.left = new TreeNode(4);
		cur.right = new TreeNode(5);
		cur = cur.left;
		cur.left = new TreeNode(8);
		cur.right = new TreeNode(9);
		cur = root.right;
		cur.left = new TreeNode(6);
		cur.right = new TreeNode(7);
		
		printTree(root);

		ListNode dummy = new ListNode(-1);
		TreeToList(root, cur.left, dummy);
		System.out.println("double linkedlist :");
		printDlist(dummy);

		TreeToList(root, root.left.left, dummy);
		System.out.println("Result:");
		printDlist(dummy);

		System.out.println("double linkedlist leavse:");
		dummy.next = null;
		LeafList(root, dummy);
		printDlist(dummy);
	}



}
