package question152;

/**
 * Created by duncan on 18-1-9.
 */
public class Solution {
    //连续子序列之积最大
    public int maxProduct(int[] nums) {
//        int len = nums.length;
//        //动态规划
//        int[][] dp = new int[len][len];
//        //初始化
//        int max = nums[0];
//        for(int i = 0; i < len; i++) {
//            dp[i][i] = nums[i];
//            if(nums[i] > max)
//                max = dp[i][i];
//        }
//        //区间内的乘积
//        for(int i =0 ; i < len; i++)
//        {
//            for(int step = 1; i + step < len; step++){
//                int j = i + step;
//                dp[i][j] = dp[i][j-1] * nums[j];
//                if(dp[i][j] > max)
//                    max = dp[i][j];
//            }
//        }
//        return max;
        int result = nums[0];
        int minHere = nums[0], maxHere = nums[0];
        for(int i=1; i<nums.length; i++) {
            int a = minHere * nums[i];
            int b = maxHere * nums[i];
            maxHere = Math.max(Math.max(a, b), nums[i]);
            minHere = Math.min(Math.min(a, b), nums[i]);
            result = Math.max(result, maxHere);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {-2};
        System.out.println(method.maxProduct(nums));
    }
}
