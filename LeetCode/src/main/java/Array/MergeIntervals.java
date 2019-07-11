package Array;/*

Example 1:
	Input: [(1,3)]
	Output: [(1,3)]

Example 2:
	Input:  [(1,3),(2,6),(8,10),(15,18)]
	Output: [(1,6),(8,10),(15,18)]


*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Definition id Interval


public class MergeIntervals{

    class Interval{
        int start, end;
        public Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return ans;
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



// merge two intervals

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> results = new ArrayList<>();
        if (list1 == null || list2 == null) {
            return results;
        }

        Interval last = null, curt = null;
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                curt = list1.get(i);
                i++;
            } else {
                curt = list2.get(j);
                j++;
            }

            last = merge(results, last, curt);
        }

        while (i < list1.size()) {
            last = merge(results, last, list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            last = merge(results, last, list2.get(j));
            j++;
        }

        if (last != null) {
            results.add(last);
        }
        return results;
    }

    private Interval merge(List<Interval> results, Interval last, Interval curt) {
        if (last == null) {
            return curt;
        }

        if (curt.start > last.end) {
            results.add(last);
            return curt;
        }

        last.end = Math.max(last.end, curt.end);
        return last;
    }
}
