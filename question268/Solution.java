package question268;

/**
 * Created by duncan on 18-1-28.
 */
public class Solution {
    //找出连续的数中缺少了哪个数
    public int missingNumber(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
        {    if(nums[0] != 0)
                return nums[0] - 1;
            else
                return 1;
        }
        //找到最小值和最大值,求和减去数组和
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE,sum = 0;
        for(int num:nums){
            if(num < min)
                min = num;
            if(max < num)
                max = num;
            sum += num;
        }
        if(min != 0)
            return 0;
        int res = ((min + max) * (max - min + 1)) / 2 - sum;
        return res == 0 ? max + 1 : res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2};
        System.out.println(method.missingNumber(nums));
    }
}
