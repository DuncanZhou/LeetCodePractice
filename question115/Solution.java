package question115;

/**
 * Created by duncan on 17-12-6.
 */
public class Solution {
//    public int numDistinct(String s, String t,int index1,int index2) {
//        //超时
//        if(index2 == t.length())
//            return 1;
//        if(index1 == s.length() && index2 != t.length())
//            return 0;
//        int sum = 0;
//        for(int i = index1; i < s.length(); i++)
//            if(s.charAt(i) == t.charAt(index2))
//                sum += numDistinct(s,t,i+1,index2+1);
//        return sum;
//    }
    public int numDistinct(String s, String t) {
//        return numDistinct(s,t,0,0);
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return 0;
        //动态规划
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[slen+1][tlen+1];
        //初始化
        for(int i = 0; i <= slen; i++)
            dp[i][0] = 1;
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= tlen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[slen][tlen];
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.numDistinct("Rabbbbit","Rabbit"));
    }
}
