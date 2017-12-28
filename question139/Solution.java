package question139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duncan on 17-12-28.
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //超时
//        if (wordDict.contains(s))
//            return true;
//        boolean flag = false;
//        for (int i = 1; i <= s.length(); i++) {
//            if (wordDict.contains(s.substring(0, i))) {
//                boolean res = wordBreak(s.substring(i), wordDict);
//                flag |= res;
//                if(res == true)
//                    break;
//            }
//        }
//        return flag;
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        if(wordDict.contains(String.valueOf(s.charAt(0)))) dp[1] = true;
        for(int i = 2; i <= len; i++){
            boolean res = false;
            for(int j = i-1; j >= 0; j--){
                if(wordDict.contains(s.substring(j,i))){
                    res |= dp[j];
                    if(res == true)
                        break;
                }
            }
            dp[i] = res;
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        List<String > wordDict = new ArrayList<String>(){{add("leet");add("code");}};
        System.out.println(method.wordBreak("leetcode",wordDict));
    }
}
