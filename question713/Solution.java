package question713;

/**
 * Created by duncan on 18-3-28.
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {2,5,6};
        System.out.println(method.numSubarrayProductLessThanK(nums,100));
    }
}
