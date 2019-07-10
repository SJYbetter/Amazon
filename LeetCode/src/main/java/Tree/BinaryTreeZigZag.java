package Tree;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        //denote for odd or even height
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            //each level extension
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();

                if (height % 2 == 1) level.add(0, cur.val);
                else level.add(cur.val);

                //extension 
                if (cur.left != null){
                    q.offer(cur.left);
                }

                if (cur.right != null){
                    q.offer(cur.right);
                }
            }//end for loop, finish one level extension
            ans.add(level);
            height ++;
    }
        return ans;
    }
}
