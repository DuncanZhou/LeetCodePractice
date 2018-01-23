package question231;

/**
 * Created by duncan on 18-1-23.
 */
public class Solution {
    //判断n是否是2的幂
    public boolean isPowerOfTwo(int n) {
        while(n % 2 == 0 && n > 1)
            n >>= 1;
        return n == 1 ? true : false;
    }
}
