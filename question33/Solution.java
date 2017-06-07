package question33;

/**
 * Created by DuncanZhou on 2016/8/31.
 */
public class Solution {
    public static int search(int[] nums,int target){
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            if (nums[l] <= nums[r]) {
                if (target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) l = mid + 1;
                else r = mid - 1;
            } else {
                if (target < nums[mid] || target > nums[r]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums ={4,5,6,7,0,1,2,3};
        System.out.println(search(nums,7));
    }
}
