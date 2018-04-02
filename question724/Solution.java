package question724;

/**
 * Created by duncan on 18-4-2.
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        //先计算数组中所有数的和
        for(int x : nums)
            sum += x;
        //开始判断
        int left = 0, right = sum,pivot = -1;
        for(int i = 0; i < nums.length; i++){
            if(i != 0)
                left += nums[i-1];
            right -= nums[i];
            if(left == right) { pivot = i;break; }
        }
        return pivot;
    }
}
