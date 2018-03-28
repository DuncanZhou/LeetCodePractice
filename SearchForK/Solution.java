package SearchForK;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-3-28.
 */
public class Solution {
    //找数组中前k个小的数
    private List<Integer> FindK(int[] nums,int k){
        int index = Partition(nums,0,nums.length-1);
        while(index != k){
            if(index < k)
                index = Partition(nums,index+1,nums.length -1);
            else index = Partition(nums,0,index-1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++)
            res.add(nums[i]);
        return res;
    }
    private int Partition(int[] nums,int start,int end){
        int temp = nums[start];
        while(start < end){
            while(start < end && nums[end] >= temp)
                end--;
            if(start < end) nums[start] = nums[end];
            while(start < end && nums[start] <= temp)
                start++;
            if(start < end) nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {7,5,9,23,4,5,6,0,12,34};
        List<Integer> res = method.FindK(nums,3);
        for (Integer x : res) {
            System.out.print(x + " ");
        }
    }
}
