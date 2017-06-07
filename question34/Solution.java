package question34;

/**
 * Created by DuncanZhou on 2016/9/2.
 */
public class Solution {
    //二分搜索
    public static int binarysearch(int[] nums,int target){
        int low = 0,high = nums.length - 1,mid,ret = -1;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ret;
    }
    public static int[] searchRange(int[] nums, int target) {
        int low,high,index;
        int[] ret = new int[2];
        //先找到该数的一个位置
        index = binarysearch(nums,target);
        if(index == -1)
        {
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        low = high = index;
        while(low >= 0 && nums[low] == target)
            low--;
        while(high < nums.length && nums[high] == target)
            high++;
        if(high - low - 1 == 1)
            ret[0] = ret[1] = index;
        else
        {
            ret[0] = low + 1;
            ret[1] = high - 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,3,3,4,5,5,5,5,6,7,7,7,8};
  //      System.out.println(binarysearch(nums,2));
        int[] ret = searchRange(nums,5);
        for(int i = 0; i < ret.length; i++ )
            System.out.print(ret[i] + " ");
    }
}
