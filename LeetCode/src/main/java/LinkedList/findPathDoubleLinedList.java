package LinkedList;

public class findPathDoubleLinedList {
	//ListNode definition
	public static class ListNode{
		int val;		
		public ListNode pre;
		public ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		
		public void push(ListNode node) {
			node.next = this.next;
			node.pre = this;
			this.next = node;
		}		
		public void pop(ListNode node) {
            //assert (node == this.next);
            //this.next = node.next;			
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
	}
	
	//TreeNode definition
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
		
	public static ListNode findPath(TreeNode root, TreeNode target) {		
		ListNode head = new ListNode(0);		
		head.pre = head;
		head.next = head;		
		if (!dfs(root, target, head)) {
			return null;
		}
		return head.next;
	
	}
	
	private static boolean dfs(TreeNode node, TreeNode target, ListNode paths) {
		if (node == null || target == null) return false;
		ListNode path_node = new ListNode(node.val);		
		paths.push(path_node);	
		//find the target
		if (node.val == target.val) {
			return true;
		}
		if (node.left != null && dfs(node.left, target, paths)) {
			return true;
		}	
		if (node.right != null && dfs(node.right, target, paths)) {
			return true;
		}
		//pop last node, if the leaves are not the target, return false
		paths.pop(path_node);		
		return false;		
	}
	
	//叶子结点连起来
	public static ListNode leavesToLinkedList(TreeNode root) {
		//initial
		ListNode head = new ListNode(0);
		head.pre = head;
		head.next = head;		
		findLeaves(root, head);
		return head.next;
	}
	// if a leaf return, else find left side and right
	private static void findLeaves(TreeNode node, ListNode path) {
		if (node == null) return;				
		//leaves
				
		if (node.left == null && node.right == null) {
			ListNode leaf = new ListNode(node.val);
			path.push(leaf);
			return;
		}
		//left side
		if (node.left != null) {
			findLeaves(node.left, path);
		}
		//right side
		if (node.right != null ) {
			findLeaves(node.right, path);	
		}
		return;		
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        TreeNode n1_1 = root.left = new TreeNode(2);
        TreeNode n1_2 = root.right = new TreeNode(3);
        TreeNode n2_1 = n1_1.left = new TreeNode(4);
        TreeNode n2_2 = n1_1.right = new TreeNode(5);
        TreeNode n2_3 = n1_2.left = new TreeNode(6);
        TreeNode n2_4 = n1_2.right = new TreeNode(7);     
        ListNode head =  findPath(root, n2_4);
        ListNode dummy = head;
        do {
        	System.out.print(dummy.val + "->");
        }while((dummy = dummy.next) != head);
        
        
        //leave 
        System.out.print("\n");
        System.out.println("leaves");
        ListNode paths = leavesToLinkedList(root);
        ListNode fake = paths;
        do {
        	System.out.print(fake.val + "->");
        }while((fake = fake.next) != paths);
        
	}

}
