package question162;

/**
 * Created by duncan on 18-1-9.
 */
public class Solution {
    //找到数组中的峰值
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        for (int i = 0; i < nums.length; i++){
            if(i == 0 && nums[i] > nums[i+1])
                return i;
            if(i != 0 && i+1 < nums.length && nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
            if(i == nums.length-1 && nums[i] > nums[i-1])
                return i;
        }
        return -1;
    }
}