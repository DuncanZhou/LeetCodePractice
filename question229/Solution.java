package question229;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-1-27.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //找出超过n/3次的数,最多两个
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == num1)
                count1++;
            else if(nums[i] == num2)
                count2++;
            else if(count1 == 0){
                num1 = nums[i];
                count1++;
            }else if(count2 == 0){
                num2 = nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        //统计num1,num2的次数
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == num1)
                count1++;
            if(nums[i] == num2)
                count2++;
        }
        if(count1 > nums.length / 3)
            res.add(num1);
        if(count2 > nums.length / 3 && num1 != num2)
            res.add(num2);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {0,0,0};
        System.out.println(method.majorityElement(nums));
    }
}
