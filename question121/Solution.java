package question121;

/**
 * Created by duncan on 17-11-29.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //超时
//        if(prices.length == 0)
//            return 0;
//        int min = Integer.MAX_VALUE;
//        int max = prices[0];
//        int res = 0;
//        for(int i = 0; i < prices.length; i++){
//            if(prices[i] < min)
//                min = prices[i];
//            //找出后面一段最大值
//            if(prices[i] == max && i != prices.length - 1){
//                max = Integer.MIN_VALUE;
//                for(int j = i + 1; j < prices.length; j++)
//                    if(prices[j] > max)
//                        max = prices[j];
//            }
//            if(max - min > res)
//                res = max - min;
//        }
//        return res;

        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.maxProfit(new int[]{}));
    }
}
