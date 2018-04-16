package question673;

import java.util.Arrays;

/**
 * Created by duncan on 18-4-16.
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[][] dp = new int[2][len];
        int max = 1,res = 0;
        Arrays.fill(dp[0],1);
        Arrays.fill(dp[1],1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[0][i] == dp[0][j] + 1) dp[1][i] += dp[1][j];
                    else if(dp[0][i] < dp[0][j] + 1){
                        dp[0][i] = dp[0][j] + 1;
                        dp[1][i] = dp[1][j];
                    }
                }
            }
            max = Math.max(max,dp[0][i]);
        }
        for(int i = 0; i < len; i++)
            if(max == dp[0][i]) res += dp[1][i];
        return res;
    }
//    private void helper(int[] nums,List<Integer> cur,List<List<Integer>> res,int len,int index){
//        if(cur.size() == len)
//            res.add(new ArrayList<>(cur));
//        if(index == nums.length)
//            return;
//        else
//        {
//            for(int i = index; i < nums.length; i++){
//                if(cur.size() == 0 || nums[i] > cur.get(cur.size()-1)){
//                    cur.add(nums[i]);
//                    helper(nums,cur,res,len,i+1);
//                    cur.remove(cur.size()-1);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Solution method = new Solution();
//        int[] nums = {1,2,4,3,5,4,7,2};
        int[] nums = {2,2,2,2,2};
        System.out.println(method.findNumberOfLIS(nums));
    }
}