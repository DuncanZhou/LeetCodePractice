package question260;

/**
 * Created by duncan on 18-1-25.
 */
public class Solution {
    //找到该数组中只出现一次的两个数
    public int[] singleNumber(int[] nums) {
        int resTwo = 0;
        int[] res = new int[2];;
        for(int i = 0; i < nums.length; i++){
            resTwo ^= nums[i];
        }
        // find the rigthest bit which is not 0
        resTwo &= -resTwo;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & resTwo) == 0){
                res[0] ^= nums[i];
            } else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
