package question97;

/**
 * Created by duncan on 17-11-14.
 */

//判断s3是不是由s1和s2交叉产生的结果
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
//        //递归方法超时
//        boolean case1 = false,case2 = false;
//        if(s1.length() + s2.length() != s3.length())
//            return false;
//        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
//            return true;
//        if((s1.length() != 0 && s3.charAt(s3.length()-1) != s1.charAt(s1.length()-1)) && (s2.length() != 0 && s3.charAt(s3.length()-1) != s2.charAt(s2.length()-1)))
//            return false;
//        if(s1.length() != 0 && s3.charAt(s3.length()-1) == s1.charAt(s1.length()-1))
//            case1 = isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1));
//        if(case1 == true)
//            return case1;
//        if(s2.length() != 0 && s3.charAt(s3.length()-1) == s2.charAt(s2.length()-1))
//            case2 = isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
//        return case1 || case2;

        if(s1.length() + s2.length() != s3.length())
            return false;
        //动态规划来做
        boolean [][] dp = new boolean[s1.length()+1][s2.length()+1];
        //初始化
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++)
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for(int i = 1; i <= s2.length(); i++)
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++)
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
        }
        return dp[s1.length()][s2.length()];

    }
    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.isInterleave("a","b","a"));
    }
}
