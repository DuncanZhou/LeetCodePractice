package question540;

/**
 * Created by duncan on 18-4-21.
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        return helper(nums);
    }
    private int helper(int[] nums){
        int start = 0,end = nums.length-1;
        while(start < end){
            int mid = ((end - start) >> 1) + start;
            int left;
            if(mid != 0 && nums[mid] == nums[mid-1])
            {
                left = mid - start - 1;
                if(left % 2 == 0) start = mid+1;
                else end = mid - 2;
            }
            else if(mid != nums.length -1 && nums[mid] == nums[mid + 1]){
                left = mid - start;
                if(left % 2 == 0) start = mid + 2;
                else end = mid - 1;
            }
            else return nums[mid];
        }
        return nums[start];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1, 1, 2, 2, 4, 4, 5, 5,9};
        System.out.println(method.singleNonDuplicate(nums));
    }
}
