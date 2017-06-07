package question53;

/**
 * Created by duncan on 17-5-4.
 */
public class Solution {
    public int maxSubArray(int[] nums){
        int maxSum = 0,lastSum = nums[0];
        //动态规划
        for(int i = 0; i < nums.length; i++){
            if(maxSum < 0)
                //舍弃前一段,因为加上这一段整体值会变小
                maxSum = nums[i];
            else
                maxSum += nums[i];
            lastSum = Math.max(maxSum,lastSum);
        }
        return lastSum;
    }
    public static void main(String[] args) {
        int[] nums = {-1,6,7,-7,-2,-6,-1,3,4,2,6,-3,-8,-1,7};
        Solution sl = new Solution();
        System.out.println(sl.maxSubArray(nums));
    }
}
