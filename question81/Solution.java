package question81;

/**
 * Created by duncan on 17-11-6.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length <= 1){
            if(nums.length == 0)
                return false;
            else
                return nums[0] == target;
        }
        int index = 0;
        if(nums[0] <= target){
            while(index < nums.length && nums[index] < target)
                index++;
            if(index == nums.length || nums[index] != target)
                return false;
            else
                return true;

        }else{
            index = nums.length - 1;
            while(index >= 0 && nums[index] > target)
                index--;
            if(index == -1 || nums[index] != target)
                return false;
            else
                return true;
        }
    }

    public static void main(String[] args) {
        Solution method =  new Solution();
        System.out.println(method.search(new int[]{3,1},3));
    }
}
