package question190;

import java.util.Stack;

/**
 * Created by duncan on 18-1-15.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int value = 0;
        // 32位无符号数
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1)
                value = (value << 1) + 1; // 左移动
             else
                value = value << 1;
            n >>= 1; // 右移
        }
        return value;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.reverseBits(1));
    }
}
