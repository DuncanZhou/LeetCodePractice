package question217;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by duncan on 18-1-21.
 */
public class Solution {
    //判断数组中是否有重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            if(!res.add(nums[i]))
                return true;
        return false;
    }

    public static void main(String[] args) {
        Solution method =  new Solution();
        int[] nums = {1,2,3,4,5,5};
        System.out.println(method.containsDuplicate(nums));
    }
}
