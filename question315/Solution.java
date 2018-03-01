package question315;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-3-1.
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //从右往左扫描,将新到的数插入到已排好序的数组中
        int[] smaller = new int[nums.length];
        for(int i=nums.length-2; i>=0; i--) {
            //二分查找
            int left = i+1;
            int right = nums.length-1;
            while (left<=right) {
                int m = (left+right)/2;
                if (nums[i] > nums[m]) right = m - 1;
                else left = m + 1;
            }
            //比它小的数的个数
            smaller[i] = nums.length - left;
            //将数填入
            int temp = nums[i];
            for(int j=i; j<right; j++) nums[j] = nums[j+1];
            nums[right] = temp;
        }
        List<Integer> results = new ArrayList<>(nums.length);
        for(int i=0; i<smaller.length; i++) results.add(smaller[i]);
        return results;
    }
}
