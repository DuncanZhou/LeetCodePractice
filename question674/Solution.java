package question674;

import java.util.Arrays;

public class Solution {
    //连续最长递增子数组
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length,max = 1;
        int[] dp = new int[len];
        //dp初始化
        Arrays.fill(dp,1);
        for(int i = 1; i < len; i++){
            dp[i] = nums[i] > nums[i-1] ? dp[i-1] + 1 : dp[i];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}
