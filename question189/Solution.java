package question189;

import java.util.Stack;

/**
 * Created by duncan on 18-1-15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--)
            if(nums.length - i > k)
                stack.push(nums[i]);
        for(int i = nums.length - 1; nums.length - i <= k; i--)
            stack.push(nums[i]);
        for(int i = 0; i < nums.length; i++)
            nums[i] = stack.pop();
    }


//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
//    }
//
//    public void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2};
        method.rotate(nums,3);
        for(int i:nums)
            System.out.print(i+" ");
    }
}
