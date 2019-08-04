package Array;

import java.util.*;

/*
 * Input: points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
   Output: [[1,1],[2,5],[4,4]]
 */
public class KClosetPoints {
	public class Point {
		    int x;
		    int y;
		    Point() { x = 0; y = 0; }
		    Point(int a, int b) { x = a; y = b; }
		  }

    private Point global_origin = null;

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        global_origin = origin;
        //corner case
        if (points == null || points.length == 0) return points;

        //Map<Point, Integer> map = new HashMap<>();
        Point[] ans = new Point[k];
        //use a prorityqueue to
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
            @Override
            public int compare(Point a, Point b) {
                int diff = getDistance(b, global_origin) - getDistance(a, global_origin);
                if (diff == 0)
                    diff = b.x - a.x;
                if (diff == 0)
                    diff = b.y - a.y;
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            //check size
            if (pq.size() > k)
                pq.poll();
        }

       // k = pq.size();
        //Point[] ret = new Point[k];
        while ( !pq.isEmpty())
            ans[--k] = pq.poll();
        return ans;
    }


     private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }





/*
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
*/

	public int[][] kClosest(int[][] points, int K) {
        int m = points.length, n = points[0].length;

        Map<int[], Integer> map = new HashMap<>();
        int[][] ans = new int[K][2];

        for (int i = 0; i < m; i++){
            int[] onePoint = points[i];
            map.put(onePoint, getDis(onePoint));
        }

        for (int i = 0; i < K; i++){
            ans[i] = Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            map.remove(ans[i]);
        }
        return ans;
    }

    private int getDis(int[] point){
	    return point[0]*point[0] + point[1]*point[1];
    }


//以matrix的形式给出，new一个新的comparator就好了

	public int[][] kCloset2(int[][] points, int k){
		//maxHeap Aaccording to its
		PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]));

		for (int i = 0; i < points.length; i++){
			pq.offer(points[i]);
			if (pq.size() > k){
				pq.poll();
			}
		}

		int[][] ans = new int[k][2];
		
		for (int i = k-1; i >= 0; i--){
			ans[i] = pq.poll();

		}
		return ans;

    }

    public int[][] kCloset3(int[][] points, int k){
	    if (points == null || points.length == 0) return new int[][]{};
	    int[][] ans = new int[k][2];
	    int[] distance = new int[points.length];
	    for (int i = 0; i < points.length; i++){
	        int dis = getDis(points[i]);
	        distance[i] = dis;
        }
        Arrays.sort(distance);
	    int checkPoint = distance[k-1];
	    int i = 0;
	    for (int j = 0; j < points.length; j++){
	        if (getDis(points[j]) <= checkPoint){
	            ans[i ++] = points[j];
            }
        }
	    return ans;
    }
}
