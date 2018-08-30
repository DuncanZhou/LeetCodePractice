package question560;

import java.util.HashMap;

public class Solution {
    //找到连续子数组和为k的数量
    public int subarraySum(int[] nums, int k) {
//        int len = nums.length,res = 0;
//
//        for(int i = 0; i < len; i++){
//            int sum = 0;
//            for(int j = i; j < len; j++){
//                sum += nums[j];
//                if(sum == k) res ++;
//            }
//        }
//        return res;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,res = 0;
        for(int x : nums){
            sum += x;
            res += map.getOrDefault(sum - k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
