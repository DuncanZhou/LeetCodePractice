package question209;

/**
 * Created by duncan on 18-1-18.
 */
public class Solution {
//    //init check
//    int start = 0;
//    int end = 0;
//
//    int sum = 0;
//    int min = Integer.MAX_VALUE;
//
//        while(start<nums.length && end<nums.length) {
//        while(sum<s && end<nums.length) {
//            sum += nums[end++];
//        }
//        while(sum>=s && start<=end) {
//            min = Math.min(min, end-start);
//            sum -= nums[start++];
//        }
//    }
//        return min==Integer.MAX_VALUE ? 0 : min;



    //找出最小的连续子序列使得和大于等于s
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = nums[start];
        while(start <= end && end < nums.length){
            if(sum <= s) {
                if(sum == s) {
                    if(end - start + 1 < minLen)
                        minLen = end - start + 1;
                    sum -= nums[start];
                    start++;
                }
                if(sum < s) {
                    end++;
                    if(end < nums.length)
                        sum += nums[end];
                }
            }else{
                if(start <= end && start < nums.length && end - start + 1 < minLen)
                    minLen = end - start + 1;
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(method.minSubArrayLen(4,nums));
    }
}
