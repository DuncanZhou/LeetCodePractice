package question62;

/**
 * Created by duncan on 17-10-31.
 */

//d[i,j] = d[i-1,j] + d[i,j-1];
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        int[][] dp = new int[m][n];
        //initial
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        for(int j = 0; j < n; j++)
            dp[0][j] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }
}
