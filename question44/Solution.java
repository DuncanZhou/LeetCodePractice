package question44;

/**
 * Created by duncan on 17-10-27.
 */

//通配符
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];//dp[i][j]为s中的前i段能匹配到p中j处
        dp[0][0] = true;
        for(int j=0;j<n;j++){
            dp[0][j+1] = dp[0][j]&&(p.charAt(j)=='*');
            for(int i=0;i<m;i++){
                if(p.charAt(j)=='*') dp[i+1][j+1] = dp[i+1][j]||dp[i][j]||dp[i][j+1];//此处的if-else语句便是本题动态规划的递推关系式
                else dp[i+1][j+1] = dp[i][j]&&(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i));
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.isMatch("aa","*a"));
    }
}
