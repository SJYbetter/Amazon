class CloneBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        if (root.val > target && root.left != null)
            closet = closestValue(root.left, target);
        else if (root.right != null)
            closet = closestValue(root.right, target);
        return Math.abs(target - root.val) <= Math.abs(target - closet) ? root.val : closet;
    }
}
