package question343;

import java.util.Arrays;

/**
 * Created by duncan on 18-2-28.
 */
public class Solution {
    //数字切割,递归超时
    public int integerBreak(int n) {
        //2 <= n <= 58
//        int max = 1;
//        if(n == 2)
//            return 1;
//        for(int k = 2; k <= n; k++)
//            if(k * integerBreak(n - k) > max)
//                max = k * integerBreak(n - k);
//        return max;
        int[] dp = new int[60];
        Arrays.fill(dp,1);
        for(int i = 3; i <= n; i++){
            int max = 1;
            for(int k = 2; k < i; k++) {
                max = Math.max(max,k * dp[i - k]);
                max = Math.max(max, k * (i - k));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.integerBreak(10));
    }
}
