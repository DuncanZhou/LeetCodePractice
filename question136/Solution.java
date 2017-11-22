package question136;

/**
 * Created by duncan on 17-11-22.
 */
public class Solution {
    //找出数组中唯一出现一次的数,线性查找复杂度,不使用额外的空间
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++)
            ans ^= nums[i];
        return ans;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.singleNumber(new int[]{1,1,2,4,2,3,3,6,6}));
    }
}
