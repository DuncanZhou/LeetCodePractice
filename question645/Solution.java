package question645;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2,cur = 0;
        int[] res = new int[2];
        for(int x : nums){
            if(nums[Math.abs(x)-1] > 0){
                cur += Math.abs(x);
                nums[Math.abs(x)-1] *= -1;
            }else res[0] = Math.abs(x);
        }
        res[1] = sum - cur;
        return res;
    }
}
