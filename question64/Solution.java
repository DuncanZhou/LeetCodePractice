package question64;

/**
 * Created by duncan on 17-10-31.
 */

//返回从矩阵最左上角到最右下角之和的最小值
    //动态规划
    //dp[i][j] = grid[i][j] + min{ dp[i-1][j],dp[i][j-1]}
public class Solution {
    public int minPathSum(int[][] grid) {
        int rowN = grid.length;
        int colN = grid[0].length;
        int[][] dp = new int[rowN][colN];
        dp[0][0] = grid[0][0];
        //初始化
        for(int i=1;i<rowN;i++)
            dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int j=1;j<colN;j++)
            dp[0][j] = grid[0][j] + dp[0][j-1];
        for(int i=1;i<rowN;i++)
            for(int j=1;j<colN;j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
        return dp[rowN-1][colN-1];
    }
}
