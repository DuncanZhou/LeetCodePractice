package question477;

/**
 * Created by duncan on 18-3-28.
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        //每一位0的个数* 1的个数
        int res = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++)
                count += (nums[j] >> i) & 1;
            res += (nums.length - count) * count;
        }
        return res;
    }
}
