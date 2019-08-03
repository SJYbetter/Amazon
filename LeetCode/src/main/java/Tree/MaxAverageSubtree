package Tree;

import DS.ListNode;

import java.util.ArrayList;
import java.util.List;

class MaxAverageSubtree {
    private class treeFamily {
        int sum;
        int count;
        treeFamily(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    
    public class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	public TreeNode(int x) {
    		this.val = x;
    	}
    }

    private TreeNode res = null;
    private treeFamily family = new treeFamily(0, 0);
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return res;
    }

    private treeFamily helper(TreeNode node) {
        //recursion exit
        if(node == null) return new treeFamily(0, 0);
        //devide
        treeFamily left = helper(node.left);
        treeFamily right = helper(node.right);
        //conquer
        treeFamily tmp = new treeFamily(left.sum + right.sum + node.val, left.cnt + right.cnt + 1);
        if(res == null || tmp.sum * family.count > tmp.count * family.sum) {
            res = node;
            family = tmp;
        }
        return tmp;
    }
}

// n-ary tree
class ComponentNode {
    ComponentNode root;
    int val;
    List<ComponentNode> componenets;

    public ComponentNode(int value) {
        root.componenets = new ArrayList<>();
        root.val = value;
    }
}


class MaxAverageSubtree1{
    class TreeFamily {
        ComponentNode root;
        int sum;
        int size;
        public TreeFamily(ComponentNode node, int sum, int size) {
            root = node;
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeFamily res = null;
    public ComponentNode highestSpeed(ComponentNode root) {
        helper(root);
        return res.root;
    }

    private TreeFamily helper(ComponentNode root) {
        if(root == null) {
            return new TreeFamily(null, 0, 0);
        }
        // if(root.components == null || root.componenets.size() == 0)
        //    return new TreeFamily(root, root.val, 1);
        List<TreeFamily> nodes = new ArrayList<>();
        for(ComponentNode t: root.componenets) {
            nodes.add(helper(t));
        }
        int childSum = 0;
        int childSize = 0;
        for(TreeFamily child: nodes) {
            childSum += child.sum;
            childSize += child.size;
        }
        TreeFamily tmp = new TreeFamily(root, childSum + root.val, childSize + 1);
        if(res == null || tmp.sum * res.size > tmp.size * res.sum) {
            if(tmp.size > 1) // leaf node not included
                res = tmp;
        }
        return tmp;
    }


}
