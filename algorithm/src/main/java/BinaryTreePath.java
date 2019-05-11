public class BinaryTreePath {

    public static class TreeNode {
        public int val;

        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public void push(ListNode new_tail_node) {
            new_tail_node.next = this.next;
            new_tail_node.prev = this;
            this.next = new_tail_node;
        }

        public void pop(ListNode new_tail_node) {
            assert (new_tail_node == this.next);
            this.next = new_tail_node.next;
        }
    }


    public static boolean findPath(TreeNode node, TreeNode target, ListNode paths) {
        if (node == null || target == null) return false;

        // push to stack( act by linked list )
        ListNode path_node = new ListNode(node.val);
        paths.push(path_node);

        if (node.val == target.val)
            return true;
        //find left side
        if (node.left != null && findPath(node.left, target, path_node))
            return true;
        //find right side
        if (node.right != null && findPath(node.right, target, path_node))
            return true;

        // pop last nodes
        paths.pop((path_node));

        return false;
    }

    public static ListNode findPath(TreeNode root, TreeNode target) {
        ListNode head = new ListNode(-1);
        head.prev = head;
        head.next = head;

        if (!findPath(root, target, head))
            return null;

        return head.next;
    }
}


