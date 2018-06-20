package question647;

public class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        Search(s,dp);
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++)
                if(dp[i][j]) count++;
        }
        return count;
    }
    private void Search(String s,boolean[][] dp){
        //初始化
        for(int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            for(int j = i + 1; j < dp.length; j++)
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = true;
        }
        for(int step = 2; step < dp.length; step++) {
            for (int i = 0; i + step < dp.length; i++) {
                int j = i + step;
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "aaa";
        System.out.println(method.countSubstrings(str));
    }
}
