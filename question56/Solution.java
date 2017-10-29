package question56;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by duncan on 17-10-29.
 */

//合并有交集的区间
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(4,5);
        Interval i2 = new Interval(1,4);
        Interval i3 = new Interval(0,1);
        Interval i4 = new Interval(11,12);
        Interval i5 = new Interval(1,10);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        Solution method = new Solution();
        List<Interval> results = method.merge(intervals);
        for(int i = 0 ; i < results.size(); i++) {
            System.out.print(results.get(i).start + " ");
            System.out.print(results.get(i).end);
            System.out.println();
        }

    }
}
