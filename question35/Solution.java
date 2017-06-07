package question35;


/**
 * Created by DuncanZhou on 2016/9/3.
 */
public class Solution {
    public int searchInsert(int[] nums,int target){
        int low = 0, high = nums.length - 1,mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,6};
        Solution sl = new Solution();
        System.out.println(sl.searchInsert(nums,5));
    }
}
