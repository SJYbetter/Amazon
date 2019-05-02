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


//修改！！！
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
    // if a leaf return true, else return false
    private static boolean findLeaves(TreeNode node, ListNode path) {
        if (node == null) return false;
        ListNode leaf = new ListNode(node.val);
        path.push(leaf);

        //leaves
        if (node.left == null && node.right == null) return true;
        //left side
        if (node.left != null && findLeaves(node.left, path)) return true;
        //right side
        if (node.right != null && findLeaves(node.right, path)) return true;
        path.pop(leaf);
        return false;
    }

    private static void printDlist(ListNode dummy) {
        ListNode tail = dummy;
        while (tail.next != dummy) {
            tail = tail.next;
            System.out.print(tail.val + "->");
        }
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

        ListNode paths =  findPath(root, n2_4);
        printDlist(paths);










    }

}

