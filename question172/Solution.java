package question172;

/**
 * Created by duncan on 18-1-10.
 */

//计算n的阶乘中末尾0的个数
public class Solution {
    public int trailingZeroes(int n) {
        //统计1-n中5的个数和末尾有0的个数
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.trailingZeroes(25));
    }
}
