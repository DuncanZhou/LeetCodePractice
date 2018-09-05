package question454;

import java.util.HashMap;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : A){
            for(int y : B){
                map.put(x+y,map.getOrDefault(x+y,0)+1);
            }
        }
        int res = 0;
        for(int x : C){
            for(int y : D){
                if(map.containsKey(-(x+y))) res += map.get(-(x+y));
            }
        }
        return res;
    }
}
