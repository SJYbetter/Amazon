public class Interval{
    int start;
    int end;
    Interval(){
        start = 0; end = 0;
    }
    Interval(int s, int s){
        start = s;
        end = e;
    }

    public boolean canAttendMeetings(Interval[] intervals){
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        int last = intervals[0].end;
        for (int i = 1; i < intervals.length; i++){
            if (last > intervals[i].start) return false;
            //update last
            last = Math.max(intervals[i].end, last);
        }
        return true;
    }
}

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
*/
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        //start time and end time array
        int[] s = new int[intervals.length];
        int[] e = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++){
            s[i] = intervals[i].start;
            e[i] = intervals[i].end;
        }

        Arrays.sort(s);
        Arrays.sort(e);

        int endId = 0, roomNumber = 0;
        for (int i = 0; i < intervals.length; i++){
            if (s[i] < e[endId]) roomNumber += 1;
            else endId ++;
        }
        return roomNumber;
    }
}
