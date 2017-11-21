package question91;

/**
 * Created by duncan on 17-11-8.
 */

//'A'-'Z':1-26
    //dp[i,j] = 1 + dp[i+1,j] + s.substring(i,i+2) > 26 ? 0 : (1 + dp[i+2,j])
public class Solution {
    public int numDecodings(String s) {


        //官方DP解法,适合从后向前遍历
//        int n = s.length();
//        if (n == 0) return 0;
//
//        int[] memo = new int[n+1];
//        memo[n]  = 1;
//        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
//
//        for (int i = n - 2; i >= 0; i--)
//            if (s.charAt(i) == '0') continue;
//            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
//
//        return memo[0];


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
