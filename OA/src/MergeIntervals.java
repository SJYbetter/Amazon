/*

Example 1:
	Input: [(1,3)]
	Output: [(1,3)]

Example 2:
	Input:  [(1,3),(2,6),(8,10),(15,18)]
	Output: [(1,6),(8,10),(15,18)]


*/

//Definition id Interval
public class Interval{
    int start, end;
    public Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
}

public class Solution{
    public List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return ans;
        //sort according to the start
        intervals.sort(Comparator.comparing(i -> i.start));
        Interval last = null;

        for (Interval item: intervals){
            //no overlap
            if (last == null || item.start > last.end){
                ans.add(item);
                //update the last 
                last = item;
            }else{
                //update the last.end
                last.end = Math.max(last.end, item.end);
            }
        }
        return ans;

    }

}
