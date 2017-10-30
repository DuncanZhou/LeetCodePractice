package question57;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by duncan on 17-10-30.
 */


class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new LinkedList<>();
        intervals.add(newInterval);
        intervals.sort((i,j)->Integer.compare(i.start,j.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start <= end)
                end = Math.max(end,intervals.get(i).end);
            else{
                results.add(new Interval(start,end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        results.add(new Interval(start,end));
        return results;
    }
}
