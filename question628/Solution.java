package question628;

import java.util.Arrays;

/**
 * Created by duncan on 18-4-20.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int a = nums[len-3] * nums[len-2] * nums[len-1];
        int b = nums[0] * nums[1] * nums[len-1];
        return a > b ? a : b;
    }
}
