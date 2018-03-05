package question330;

/**
 * Created by duncan on 18-3-5.
 */
public class Solution {
    /*
    定义整数bound，[0,bound)是现在能满足的区间，即[0,bound)内的数字都能被表示出来。
    数列中往后读一个数num，如果num<=bound，那么我们可以扩展区间为[0,bound+num)；
    如果num>bound，那么我们就需要添加一个数字来扩展区间，最有效的值显然为bound本身，区间扩展为[0,bound+bound)。(贪心算法)
    定义bound初始值为1，循环读取数列中的数字并扩展区间，直到bound>n即可。
     */
    public int minPatches(int[] nums, int n) {
        int count = 0,i = 0;
        //bound可能会溢出int范围
        long bound = 1;
        while(bound <= n){
            //[1,nums[i]) + [nums[i],nums[i]+bound)
            if(i < nums.length && nums[i] <= bound)
                bound += nums[i++];
            else{
                count++;
                bound <<= 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2,31,33};
        System.out.println(method.minPatches(nums,2147483647));
    }
}
