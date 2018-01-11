package question174;

/**
 * Created by duncan on 18-1-11.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0 || dungeon[0].length == 0)
            return 1;
        int rowN = dungeon.length;
        int colN = dungeon[0].length;
        int[][] dp = new int[rowN][colN];
        //从右下角向左上角推
        for(int i = rowN - 1; i >= 0; i--){
            for(int j = colN - 1; j >= 0; j--){
                if(i == rowN - 1 && j == colN - 1)
                    dp[i][j] = Math.max(1,1-dungeon[i][j]);
                else if(i == rowN - 1)
                    //只能来源于右方
                    dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                else if(j == colN - 1)
                    dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                else
                    dp[i][j] = Math.max(1, Math.min(dp[i+1][j] - dungeon[i][j],dp[i][j+1]-dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
}
