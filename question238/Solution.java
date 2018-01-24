package question238;

import java.util.Arrays;

/**
 * Created by duncan on 18-1-24.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        long res = 1,count = 0;
        int index = 0;
        int[] results = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                res *= nums[i];
            else {
                count++;
                index = i;
            }
        }
        if(count >= 2) {
            Arrays.fill(results, 0);
            return results;
        }else if(count == 1){
            results[index] = (int)res;
            return results;
        }
        for(int i = 0; i < nums.length; i++)
            results[i] = (int)(res / nums[i]);
        return results;
    }
}
