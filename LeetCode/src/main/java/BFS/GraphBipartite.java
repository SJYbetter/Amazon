import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (color[i] != 0) continue;
            //initial
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1;           
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int nextNode: graph[cur]){
                    //not colored
                    if (color[nextNode] == 0){
                        color[nextNode] = color[cur] * -1;
                        q.offer(nextNode);
                    }else if(color[nextNode] == color[cur]){
                        return false;
                    }
                }
                
            }
        }
        return true;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
