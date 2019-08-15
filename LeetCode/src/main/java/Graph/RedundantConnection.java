package Graph;

public class RedundantConnection {
    private int find(int[] roots, int i){
        if (roots[i] == i) return i;
        return find(roots, roots[i]);
    }

    private void union(int[] root, int i, int j){
        if (root[i] == root[j]) return;
        if (root[i] != root[j]){
            int parent_i = root[i];
            int parent_j = root[j];
            root[parent_j] = root[parent_i];
        }
    }
    public int[] findRedundant_unionfind(int N, int[][] edges){
        if (edges == null || edges.length == 0) return new int[]{};
        int[] roots = new int[N+1];
        for (int i = 1; i <= N; i++){
            roots[i] = i;
        }
        for (int i = 0; i < edges.length; i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (find(roots, node1) == find(roots, node2)) return edges[i];
            else{
                union(roots, node1, node2);
            }
        }
        return new int[]{};
    }
}
