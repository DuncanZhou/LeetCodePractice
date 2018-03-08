package question309;

/**
 * Created by duncan on 18-2-28.
 */
public class Solution {
    //超时
//    int max = 0;
//    public void maxProfit(int[] prices, int curProfit,int start){
//        if(curProfit > max)
//            max = curProfit;
//        if(start >= prices.length)
//            return;
//        for(int i = start; i < prices.length - 1; i++){
//            for(int j = i + 1; j < prices.length; j++)
//                if(prices[j] > prices[i]){
//                    maxProfit(prices,curProfit + prices[j] - prices[i], j + 2);
//                }
//        }
//    }
    public int maxProfit(int[] prices) {
//        maxProfit(prices,0,0);
//        return max;
        //动态规划
//        int len = prices.length;
//        int[][] dp = new int[len+1][len];
//        if(prices == null || len == 0 || len == 1 || (len == 2 && prices[1] < prices[0]))
//            return 0;
//        for(int step = 1; step < len ; step++){
//            for(int i = 0; i < len && i + step < len; i++){
//                int j = i + step;
//                int profit = 0;
//                if(step == 1) {
//                    dp[i][j] = prices[j] > prices[i] ? prices[j] - prices[i] : 0;
//                    continue;
//                }
//                for(int k = i + 2; k < j; k++){
//                    if(dp[i][k-1] + dp[k+1][j] > profit)
//                        profit = dp[i][k-1] + dp[k+1][j];
//                }
//                for(int k = i; k <= j - 1; k++)
//                    if(dp[k][j] > profit)
//                        profit = dp[k][j];
//                dp[i][j] = profit;
//            }
//        }
//        return dp[0][len-1];
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] sdp = new int[prices.length];
        int[] bdp = new int[prices.length];
        sdp[0] = 0;
        bdp[0] = -prices[0];
        for (int i = 1;i < prices.length ;i++ ) {
            sdp[i] = Math.max(sdp[i-1],bdp[i-1] + prices[i]);
            if(i >= 2) {
                bdp[i] = Math.max(bdp[i-1],sdp[i-2] - prices[i]);
            } else {
                bdp[i] = Math.max(bdp[i-1],-prices[i]);
            }
        }
        return sdp[prices.length - 1];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] prices = {2,1,100};
        System.out.println(method.maxProfit(prices));
    }
}
