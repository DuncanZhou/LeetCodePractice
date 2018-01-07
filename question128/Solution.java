package question128;


import java.util.HashSet;

/**
 * Created by duncan on 18-1-7.
 */
public class Solution {
    //没有排序的数组,找出最长的连续子序列长度
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();

        for(int i = 0;i<nums.length;i++)
            sets.add(nums[i]);

        int max = 0;
        int count;
        for(int i = 0;i<nums.length;i++){
            count = 0;
            int val = nums[i];
            int valTmp = val;
            //向右找
            while(sets.contains(valTmp)){
                count++;
                sets.remove(val);
                valTmp++;
            }
            //向左找
            while(sets.contains(val-1)){
                count++;
                sets.remove(val-1);
                val--;
            }
            if(count>max)
                max = count;
        }
        return max;
    }
}
