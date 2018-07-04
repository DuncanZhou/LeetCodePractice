package question462;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        int sum = 0;
        //寻找中位数
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        for(int x : nums) sum += Math.abs(x - median);
        return sum;
    }
}
