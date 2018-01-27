package question169;

/**
 * Created by duncan on 18-1-27.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int num = 0,count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(num == nums[i] || count == 0){
                num = nums[i];
                count++;
            }
            else if(num != nums[i])
                count--;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2,3,4,1,2};
        System.out.println(method.majorityElement(nums));
    }
}
