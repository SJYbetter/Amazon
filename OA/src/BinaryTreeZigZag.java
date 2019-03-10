class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if (height % 2 == 1) level.add(0, cur.val);
                else level.add(cur.val);

                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
            ans.add(level);
            height ++;
    }
        return ans;
    }
}
