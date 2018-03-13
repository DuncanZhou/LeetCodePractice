package question416;

import java.util.Arrays;

/**
 * Created by duncan on 18-3-13.
 */
public class Solution {
    public boolean canPartition(int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for(int x : nums) sum += x;
//        if(sum % 2 != 0) return false;
//        return dfs(nums,sum / 2,nums.length - 1);
        int sum = 0,max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(nums[i],max);
        }
        if(sum % 2 != 0 || max > sum / 2) return false;
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = sum / 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 0; i < nums.length; i++) {
            //从大到小动规计算
            for (int j = volumn; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[volumn];
        //动规
//        boolean[] dp = new boolean[sum / 2 +1];
//        dp[0] = true;
//        //初始化
//        for(int i = 0; i < nums.length; i++)
//            dp[nums[i]] = true;
//        for(int i = 1; i <= sum / 2; i++){
//            boolean temp = false;
//            if(dp[i]) continue;
//            for(int j = 0; j < nums.length; j++)
//                if(i >= nums[j] && dp[i-nums[j]]){
//                    temp = true;
//                    break;
//                }
//            dp[i] = temp;
//        }
//        return dp[sum / 2];
    }
    //nums排序好了
    private boolean dfs(int[] nums, int target, int index){
        if(index < 0 || nums[0] > target) return false;
        if(nums[index] == target) return true;
        return dfs(nums,target,index-1) | dfs(nums,target-nums[index],index-1);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {2,2,3,5};
        System.out.println(method.canPartition(nums));
    }
}
