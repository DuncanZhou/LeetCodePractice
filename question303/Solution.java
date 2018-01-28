package question303;

/**
 * Created by duncan on 18-1-28.
 */

class NumArray {

    int[] array;
    int[] dp;
    public NumArray(int[] nums) {
        array = nums;
        //dp保留每个段的总和
        dp = new int[nums.length];
        if(nums.length == 0)
            return;
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            dp[i] += dp[i-1] + nums[i];
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i-1];
    }
}

public class Solution {
}
