package question368;

import java.util.*;

/**
 * Created by duncan on 18-3-7.
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int[] path = new int[nums.length];
        //动规
        //dp[i] = max(dp[j]) + 1 (nums[i] % nums[j] == 0)
        int[] dp = new int[nums.length];
        dp[0] = 1;
        path[0] = -1;
        for(int i = 1; i < nums.length; i++){
            int max = 1,pre = -1;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > max) {
                    max = dp[j] + 1;
                    pre = j;
                }
            }
            dp[i] = max;
            path[i] = pre;
        }
        int max = 1,index = 0;
        for(int i = 0; i < dp.length; i++)
            if(dp[i] > max) {
                max = dp[i];
                index = i;
            }
        //找到最长的之后,开始将数填到列表中
        res.add(nums[index]);
        index = path[index];
        while(index != -1){
            res.add(nums[index]);
            index = path[index];
        }
        return res;
    }


    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {};
        List<Integer> res = method.largestDivisibleSubset(nums);
        for(int x : res)
            System.out.print(x+" ");
    }
}
