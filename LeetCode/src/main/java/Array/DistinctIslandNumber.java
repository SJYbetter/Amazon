package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DistinctIslandNumber {
    private int m;
    private int n;

    public int distinctNumberIsland(int[][] grid){
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    sb.append("O");
                    dfs(i, j, grid, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();

    }

    private void dfs(int x, int y, int[][] grid, StringBuilder sb){
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return;
        grid[x][y] = 0;
        dfs(x+1, y, grid, sb.append("R"));
        dfs(x, y + 1, grid, sb.append("U"));
        dfs(x-1, y, grid, sb.append("L"));
        dfs(x, y - 1, grid, sb.append("D"));
    }
}
