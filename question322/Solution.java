package question322;

import java.util.Arrays;

/**
 * Created by duncan on 18-3-2.
 */
public class Solution {
    //递归一般都是超时
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0)
            return 0;
        Arrays.sort(coins);
        return Find(amount,coins,coins.length-1,0);
    }
    public int Find(int target,int[] coins,int index,int count){
        if(index == -1)
            return -1;
        if(coins[index] == target)
            return count + 1;
        if(coins[index] > target)
            return Find(target,coins,index-1,count);
        else{
            int res1 = Find(target-coins[index],coins,index,count+1);
            int res2 = Find(target,coins,index-1,count);
            if(res1 != -1 && res2 != -1)
                return Math.min(res1,res2);
            else return res1 == -1 ? res2 : res1;
        }
    }
}
