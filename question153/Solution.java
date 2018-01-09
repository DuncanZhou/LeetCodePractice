package question153;

/**
 * Created by duncan on 18-1-9.
 */
public class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        if(nums.length == 1)
            return res;
        for(int i = 0; i < nums.length - 1; i++)
            if(nums[i] > nums[i+1])
                return nums[i+1];
        return res;
    }
}
