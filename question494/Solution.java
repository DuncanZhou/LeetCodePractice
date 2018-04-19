package question494;

/**
 * Created by duncan on 18-4-19.
 */
public class Solution {
    //给nums中的数添加符号,使得之和为s
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums,0,S);
    }
    private int dfs(int[] nums,int index,int target){
        if(index == nums.length){
            return target == 0 ? 1: 0;
        }
        int plus = dfs(nums,index+1,target-nums[index]);
        int minus = dfs(nums,index+1,target+nums[index]);
        return plus + minus;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,1,1,1,1};
        System.out.println(method.findTargetSumWays(nums,3));
    }
}
