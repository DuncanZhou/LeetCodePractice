package question69;

/**
 * Created by duncan on 17-11-1.
 */
public class Solution {

    public int mySqrt(int x) {
        //牛顿迭代法
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int)r;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.mySqrt(5));
    }
}
