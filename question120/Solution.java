package question120;

import java.util.List;

/**
 * Created by duncan on 17-11-29.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        //初始化
        dp[0][0] = triangle.get(0).get(0);
        for(int row = 1; row < rows; row++){
            List<Integer> cur = triangle.get(row);
            int col = cur.size();
            int lastCol = triangle.get(row - 1).size();
            for(int j = 0; j < col; j++)
                dp[row][j] = Math.min(j >= 0 && j < lastCol ? dp[row-1][j] : Integer.MAX_VALUE,j-1 >= 0 ? dp[row-1][j-1] : Integer.MAX_VALUE)  + cur.get(j);
        }
        //返回最后一行中最小的
        int min = dp[rows-1][0];
        for(int j = 1; j < rows; j++)
            if(dp[rows-1][j] < min)
                min = dp[rows-1][j];
        return min;
    }
}
