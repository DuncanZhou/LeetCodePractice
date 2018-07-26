package question503;

public class Solution    {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            //search
            int j;
            for(j = (i + 1 + len) % len; j != i; j = (j + 1 + len) % len){
                if(nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if(j == i) res[i] = -1;
        }
        return res;
    }
}
