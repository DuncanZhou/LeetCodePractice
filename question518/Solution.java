package question518;

/**
 * Created by duncan on 18-4-20.
 */
public class Solution {
    public int change(int amount, int[] coins) {
//        //动态规划
//        int[][] dp = new int[coins.length+1][amount+1];
//        dp[0][0] = 1;
//        for(int i = 1; i <= coins.length; i++){
//            dp[i][0] = 1;
//            for(int j = 1; j <= amount; j++){
//                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
//            }
//        }
//        return dp[coins.length][amount];
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i = coin; i <= amount; i++)
                dp[i] += dp[i-coin];
        }
        return dp[amount];
    }
}
