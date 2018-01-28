package question283;

/**
 * Created by duncan on 18-1-28.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        //将所有的0都移到最后
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }
        //在index到nums.leng都填充0
        for(int i = index; i < nums.length; i++)
            nums[i] = 0;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        method.moveZeroes(nums);
        for(int i: nums)
            System.out.print(i + " ");
    }
}
