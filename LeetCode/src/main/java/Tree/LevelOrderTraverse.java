package Tree;


import DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverse {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        //edge case
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            //size is changing all the time
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            //for each level
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                if (head.left != null) q.offer(head.left);
                if (head.right != null) q.offer(head.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
