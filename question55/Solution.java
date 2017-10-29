package question55;

/**
 * Created by duncan on 17-10-29.
 */

//jump game
public class Solution {
    public boolean canJump(int[] nums) {
        int nextrange = 0;
        for(int i = 0; i < nums.length; i++){
            if(nextrange >= nums.length - 1)
                return true;
            if(i > nextrange)
                return false;
            nextrange = Math.max(nums[i] + i,nextrange);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {0,2,3};
        System.out.println(method.canJump(nums));
    }
}
