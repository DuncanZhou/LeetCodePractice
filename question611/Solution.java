package question611;

import java.util.Arrays;

/**
 * Created by duncan on 18-6-1.
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[k] < nums[i] + nums[j]) res++;
                    else break;
                }
            }
        }
        return res;
    }
}
