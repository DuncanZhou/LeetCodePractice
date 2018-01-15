package question198;

/**
 * Created by duncan on 18-1-15.
 */
public class Solution {
    int res = 0;
    //深搜超时
    public void dfs(int[] nums,int index,int cur){
        if(index >= nums.length) {
            if(cur > res)
                res = cur;
            return;
        }
        dfs(nums,index+1,cur);
        dfs(nums,index+2,cur+nums[index]);
    }
    public int rob(int[] nums) {
        dfs(nums,0,0);
        return res;


//        int[][] dp = new int[num.length + 1][2];
//        for (int i = 1; i <= num.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
//            dp[i][1] = num[i - 1] + dp[i - 1][0];
//        }
//        return Math.max(dp[num.length][0], dp[num.length][1]);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {6,7,20,30,2,10};
        System.out.println(method.rob(nums));
    }
}
