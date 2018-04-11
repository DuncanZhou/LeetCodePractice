package question495;

import java.util.Arrays;

/**
 * Created by duncan on 18-4-11.
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;
        if(timeSeries.length == 1) return duration;
        Arrays.sort(timeSeries);
        int start = timeSeries[0],end = start + duration;
        int total = duration;
        for(int next : timeSeries){
            int curs = next, cure = next + duration;
            //判断交叠部分
            if(curs < end)
                total += duration - (end - curs);
            else total += duration;
            start = curs;
            end = cure;
        }
        return total;
    }
}
