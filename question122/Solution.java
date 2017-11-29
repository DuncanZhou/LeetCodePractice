package question122;

/**
 * Created by duncan on 17-11-29.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 0; i < prices.length - 1; i++)
            sum += prices[i+1] > prices[i] ? prices[i+1]-prices[i] : 0;
        return sum;
    }
}
