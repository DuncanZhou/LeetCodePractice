package question137;

/**
 * Created by duncan on 17-12-27.
 */
public class Solution {
    //数组中每个数都出现了3次,除了一个数,找到那个数
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;
            for(int x:nums){
                if(((x>>i)&1) == 1){
                    sum ++;
                    sum %= 3;
                }
            }
            if(sum != 0)
                res |= sum << i;
        }
        return res;
    }
}
