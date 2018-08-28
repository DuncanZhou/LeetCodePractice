package question525;

import java.util.HashMap;

public class Solution {
    //寻找最长长度的0,1相等数目的子数组
    public int findMaxLength(int[] nums) {
        int len = nums.length,max = 0;
        int[][] zero = new int[len][len];
        int[][] one = new int[len][len];
        for(int i = 0; i < len; i++)
            if(nums[i] == 0) zero[i][i] = 1;
            else one[i][i] = 1;
        for(int step = 1; step < len; step++){
            for(int i = 0; i + step < len; i++){
                int j = i + step;
                zero[i][j] = zero[i][j-1] + (nums[j] == 0 ? 1 : 0);
                one[i][j] = one[i][j-1] + (nums[j] == 1 ? 1: 0);
            }
        }
        for(int step = 1; step < len; step += 2){
            for(int i = 0; i + step < len; i++){
                if(zero[i][i+step] == one[i][i+step] && step + 1 > max)
                    max = step + 1;
            }
        }
        return max;
    }

    private int helper(int[] nums){
        //HashMap
        int sum = 0,max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)) max = Math.max(max,i - map.get(sum));
            else map.put(sum,i);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {0,1};
        System.out.println(method.helper(nums));
    }

}
