package question435;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by duncan on 18-5-8.
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        List<Interval> results = new ArrayList<Interval>();
        for(Interval i : intervals)
            results.add(i);
        results.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)
                    return o1.start - o2.start;
                else return o1.end - o2.end;
            }
        });
        int res = 0;
        Interval cur = results.get(0);
        for(int i = 1; i < results.size(); i++){
            Interval temp = results.get(i);
            if(temp.start >= cur.start && temp.start < cur.end) {
                res++;
                if(temp.end < cur.end) cur = temp;
            }
            else cur = temp;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
