public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    //public BSTIterator(){};

    public BSTIterator(TreeNode root) {
        while (root != null){
            stack.push(root);
            root = root.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode node = cur;
        if(node.right != null){
            node = node.right;
            while (stack != null){
                stack.push(node);
                if(node.left != null)
                    node = node.left;
                else
                    break;
            }
        }
        return cur.val;
    }

}
