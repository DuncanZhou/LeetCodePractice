package question300;

import java.util.Arrays;

/**
 * Created by duncan on 18-2-26.
 */
public class Solution {
    //找到数组中最长的递增子序列
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],1+dp[j]);
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,3,6};
        System.out.println(method.lengthOfLIS(nums));
    }
}
