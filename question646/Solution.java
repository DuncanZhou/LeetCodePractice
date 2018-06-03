package question646;

import java.util.Arrays;

/**
 * Created by duncan on 18-6-3.
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        //按照第一位排序
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1]? dp[j] + 1 : dp[j]);
            }
        }
        return dp[pairs.length - 1];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] nums = {{3,10},{3,7},{7,10},{7,9},{-1,7},{-9,5},{2,8}};
        System.out.println(method.findLongestChain(nums));
    }
}
