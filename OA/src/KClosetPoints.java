import java.util.Comparator;
import java.util.PriorityQueue;

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
        
        if (points == null || points.length == 0) return points;
        
        //Map<Point, Integer> map = new HashMap<>();
        Point[] ans = new Point[k];
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
            if (pq.size() > k)
                pq.poll();
        }
        
        k = pq.size();
        Point[] ret = new Point[k];  
        while (!pq.isEmpty())
            ret[--k] = pq.poll();
        return ret;
    }
        
 
     private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

}
