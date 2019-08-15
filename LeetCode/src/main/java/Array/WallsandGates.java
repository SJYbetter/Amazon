package Array;

import java.util.LinkedList;
import java.util.Queue;

/*
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room.
We use the value 231 - 1 = 2147483647 to represent
INF as you may assume that the distance to a gate is less than 2147483647.
*/
public class WallsandGates {
    //bfs
    public void wallAndGates(int[][] rooms){
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }

            }
        }

        while (!queue.isEmpty()){
            int[] cordi = queue.poll();
            int x = cordi[0], y = cordi[1];
            if (x + 1 < m && rooms[x+1][y] == Integer.MAX_VALUE) {
                rooms[x + 1][y] = rooms[x][y] + 1;
                queue.add(new int[]{x+1, y});
            }
            if (x - 1 >= 0 && rooms[x-1][y] == Integer.MAX_VALUE){
                rooms[x-1][y] = rooms[x][y] + 1;
                queue.add(new int[]{x-1, y});
            }
            if (y + 1 < n && rooms[x][y+1] == Integer.MAX_VALUE){
                rooms[x][y+1] = rooms[x][y] + 1;
                queue.add(new int[]{x, y+1});
            }
            if (y - 1 < n && rooms[x][y-1] == Integer.MAX_VALUE){
                rooms[x][y-1] = rooms[x][y] + 1;
                queue.add(new int[]{x, y-1});
            }
        }
    }


}
