package question258;

/**
 * Created by duncan on 18-1-24.
 */
public class Solution {
    //拆分数字,直到其只有一位
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
