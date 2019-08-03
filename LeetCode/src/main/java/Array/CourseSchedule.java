package Array;

import java.util.*;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        if (prerequisites == null || prerequisites.length == 0) return true;

        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][cur] == 0)
                indegree[cur]++;
            matrix[pre][cur] = 1;
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[cur][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        //edge case
        if (numCourses == 0) return true;
        if (prerequisites == null || prerequisites.length == 0) return true;
        //key is course, value is later course after take "key" course
        Map<Integer, List<Integer>> map = new HashMap<>();
        //cal the indegree to put in queue
        int[] indegree = new int[numCourses];
        //go through the input to update the indegree and the matrix
        for (int i = 0; i < prerequisites.length; i++){
            int first = prerequisites[i][1];
            int last = prerequisites[i][0];
            indegree[last] ++;
            if (!map.containsKey(first)){
                map.put(first, new ArrayList<>());
            }
            map.get(first).add(last);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()){
            int pre = q.poll();
            count ++;
            List<Integer> neighbor = map.get(pre);
            //System.out.println(neighbor);
            //！！！！！！很重要！！！！
            if (neighbor == null) continue;
            for (int i: neighbor){
                indegree[i] --;
                if (indegree[i] == 0){
                    q.offer(i);
                }
            }
        }
        return count == numCourses;

    }
}
