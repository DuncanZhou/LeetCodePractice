package question539;

import java.util.Arrays;
import java.util.List;

/**
 * Created by duncan on 18-4-13.
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int index = 0;
        for(String str : timePoints)
            times[index++] = Convert(str);
        Arrays.sort(times);
        int res = times[1] - times[0],cur = 1;
        for(int i = 2; i < times.length; i++){
            if(times[i] - times[cur] < res) res = times[i] - times[cur];
            cur = i;
        }
        if(1440 - times[times.length - 1] + times[0] < res) res = 1440 - times[times.length - 1] + times[0];
        return res;
    }
    public int Convert(String time){
        String[] temp = time.split(":");
        return Integer.valueOf(temp[0]) * 60 + Integer.valueOf(temp[1]);
    }
}
