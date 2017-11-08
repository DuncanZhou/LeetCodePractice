package question91;

/**
 * Created by duncan on 17-11-8.
 */

//'A'-'Z':1-26
    //dp[i,j] = 1 + dp[i+1,j] + s.substring(i,i+2) > 26 ? 0 : (1 + dp[i+2,j])
public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[][] dp = new int[len][len];
        //初始化
        for(int i = 0; i < len; i++)
            if(s.charAt(i) - '0' >= 1 && s.charAt(i)-'0' <= 9) {
                dp[i][i] = 1;
            }
        //动态规划
        for(int step = 1; step < len; step ++){
            for(int start = 0; start + step < len; start++)
            {
                int end = start + step;
                if(s.charAt(start) == '0') {
                    dp[start][end] = 0;
                    continue;
                }
                dp[start][end] = dp[start + 1][end];
                int temp = Integer.valueOf(s.substring(start, start + 2));
                if(temp <= 26)
                    dp[start][end] += ((start + 2) > end ? 1 : dp[start+2][end]);
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.numDecodings("202"));
    }
}
