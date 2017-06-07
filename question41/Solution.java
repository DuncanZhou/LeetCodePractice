package question41;

import java.util.Arrays;

/**
 * Created by DuncanZhou on 2016/9/9.
 */
public class Solution {
    public int firstMissingPositive(int[] nums){
        Arrays.sort(nums);
        int index ,check = 0,i;
        for(i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                index = nums[i];
                if(check == 0) {
                    check = index;
                    if(check != 1)
                        return 1;
                }
                if(i != 0 && nums[i] == nums[i - 1])
                    check--;
                if(nums[i] != check)
                    break;
                check ++;
            }
        }
        if(check == 0)
            check = 1;
        return check;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        Solution sl = new Solution();
        System.out.println(sl.firstMissingPositive(nums));
    }
}
