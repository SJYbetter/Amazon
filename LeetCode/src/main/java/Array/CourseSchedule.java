package Array;

import java.util.LinkedList;
import java.util.Queue;

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
}
