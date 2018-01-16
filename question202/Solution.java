package question202;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by duncan on 18-1-16.
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum,remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;

        }
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.isHappy(32));
    }
}
