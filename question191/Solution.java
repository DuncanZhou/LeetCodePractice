package question191;

/**
 * Created by duncan on 18-1-15.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //判断n的二进制中有多少1
        int count = 0;
        for(int i = 0; i < 32; i ++){
            if((n & 1) == 1)
                count ++;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.hammingWeight(11));
    }
}
