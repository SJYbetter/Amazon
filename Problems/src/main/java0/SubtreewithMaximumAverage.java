import java.util.List;

public class SubtreewithMaximumAverage {

    private class NodeSummary {
        int total;
        int count;

        public NodeSummary(int total, int count) {
            this.total = total;
            this.count = count;
        }
    }

    private static class TreeNode {
        int val;
        List<TreeNode> children;
    }

    private NodeSummary max_summary = null;
    private TreeNode max_node = null;

    public NodeSummary fix_max_node(NodeSummary currentSummary, TreeNode currentNode) {
        if (max_summary == null ||
                (currentSummary.total * 1.0 / currentSummary.count) > (max_summary.total * 1.0 / max_summary.count)) {
            max_summary = currentSummary;
            max_node = currentNode;
        }
        return currentSummary;
    }

    public NodeSummary find_max_average_subtree(TreeNode node) {
        if (node.children == null || node.children.size() == 0) {
            return fix_max_node( new NodeSummary(1, node.val), node);
        }

        int child_total = 0;
        int child_count = 0;

        for (TreeNode child : node.children) {
            NodeSummary summary = this.find_max_average_subtree(child);
            child_total += summary.total;
            child_count += summary.count;
        }

        return fix_max_node(new NodeSummary(child_total + node.val, child_count + 1), node);
    }

    public static void main(String[] argv) {
        TreeNode root = new TreeNode();

        new SubtreewithMaximumAverage().find_max_average_subtree(root);


    }
}
