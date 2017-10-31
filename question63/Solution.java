package question63;

/**
 * Created by duncan on 17-10-31.
 */

//递归回溯超时
public class Solution {
    public int uniquePath(int[][] matrix,int i,int j){
        int rowN = matrix.length;
        int colN = matrix[0].length;
        if(i >= rowN || j >= colN)
            return 0;
        if(matrix[0][0] == 1)
            return 0;
        if(i == rowN - 1 && j == colN - 1 && matrix[i][j] == 0){
            return 1;
        }else{
            int down = 0,right = 0;
            //向下
            if(i+1 < rowN && matrix[i + 1][j] == 0)
                down = uniquePath(matrix,i+1,j);
            //向右
            if(j+1 < colN && matrix[i][j+1] == 0)
                right = uniquePath(matrix,i,j+1);
            return down + right;
        }
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        return uniquePath(obstacleGrid,0,0);
        int rowN = obstacleGrid.length;
        int colN = obstacleGrid[0].length;
        int[][] dp = new int[rowN][colN];
        //初始化
        int value = 1;
        for (int i = 0; i < rowN; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = value;
            else {
                value = 0;
                dp[i][0] = value;
            }
        }
        value = 1;
        for (int j = 0; j < colN; j++) {
            if (obstacleGrid[0][j] == 0)
                dp[0][j] = value;
            else {
                value = 0;
                dp[0][j] = value;
            }
        }
        for (int i = 1; i < rowN; i++) {
            for (int j = 1; j < colN; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    if (obstacleGrid[i - 1][j] != 1)
                        dp[i][j] = dp[i - 1][j];
                    if (obstacleGrid[i][j - 1] != 1)
                        dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[rowN-1][colN-1];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
