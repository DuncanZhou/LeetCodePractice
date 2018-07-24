package question821;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //统计每个字符距某个字符最小的距离
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        //记录c在s中的每个位置
        List<Integer> position = new ArrayList<>();
        for(int i = 0; i < S.length(); i++)
            if(S.charAt(i) == C) position.add(i);
        //遍历
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == C) res[i] = 0;
            else{
                int min = S.length();
                for(int x : position){
                    if(Math.abs(x - i) < min) min = Math.abs(x - i);
                }
                res[i] = min;
            }
        }
        return res;
    }
}
