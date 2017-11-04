package question75;

import java.util.Arrays;

/**
 * Created by duncan on 17-11-4.
 */


//nums数组中只有0,1,2,排序
public class Solution {
    public void Swap(int[] nums, int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int QuickSort(int[] nums,int start,int end,int split){
        while (start < end){
            while(start < end && nums[start] <= split)
                start++;
            while(start < end && nums[end] > split)
                end--;
            if(start < end)
                Swap(nums,start,end);
            start++;
            end--;
        }
        return end + 1;
    }
    public void sortColors(int[] nums) {
        if(nums.length <= 2)
        {
            if(nums.length == 1)
                return;
            if(nums[0] > nums[1])
                Swap(nums,0,1);
            return;
        }
        //先按1切分
        int position = QuickSort(nums,0,nums.length-1,1);
        QuickSort(nums,0,position,0);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1};
        method.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
