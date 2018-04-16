package question698;

import java.util.Arrays;

/**
 * Created by duncan on 18-4-16.
 */
public class Solution {
    //判断是否能将数组分为k个和相等的子数组
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] res = new int[k];
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(sum % k != 0) return false;
        Arrays.sort(nums);
        int target = sum / k;
        if(nums[nums.length - 1] > target) return false;
        return helper(nums,res,nums.length-1,target);
    }
    private boolean helper(int[] nums,int[] res,int index,int target){
        if(index == -1){
            boolean flag = true;
            for(int i = 0; i < res.length; i++)
                if(res[i] != target){flag = false; break;}
            return flag;
        }else{
            for(int i = 0; i < res.length; i++){
                if(res[i] + nums[index] <= target) {
                    res[i] += nums[index];
                    if (helper(nums, res, index - 1, target)) return true;
                    res[i] -= nums[index];
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {724,3908,1444,522,325,322,1037,5508,1112,724,424,2017,1227,6655,5576,543};
        System.out.println(method.canPartitionKSubsets(nums,4));
    }
}
