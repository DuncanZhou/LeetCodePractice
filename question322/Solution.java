package question322;

import java.util.Arrays;

/**
 * Created by duncan on 18-3-2.
 */
public class Solution {
    //递归一般都是超时
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        //初始化
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount)
                dp[coins[i]] = 1;
        }
        //动规
        for(int M = 1; M <= amount; M++){
            for(int j = 0; j < coins.length; j++){
                for(int k = 1; coins[j] * k <= M; k++){
                    dp[M] = Math.min(dp[M], k + dp[M-k*coins[j]]);
                }
            }
        }
        if(dp[amount] == amount+1) return -1;
        else return dp[amount];
//        if(amount <= 0)
//            return 0;
//        Arrays.sort(coins);
//        return Find(amount,coins,coins.length-1,0);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] coins = {1,2,5,10};
        System.out.println(method.coinChange(coins,18));
    }
//    public int Find(int target,int[] coins,int index,int count){
//        if(index == -1)
//            return -1;
//        if(coins[index] == target)
//            return count + 1;
//        if(coins[index] > target)
//            return Find(target,coins,index-1,count);
//        else{
//            int res1 = Find(target-coins[index],coins,index,count+1);
//            int res2 = Find(target,coins,index-1,count);
//            if(res1 != -1 && res2 != -1)
//                return Math.min(res1,res2);
//            else return res1 == -1 ? res2 : res1;
//        }
//    }
}
