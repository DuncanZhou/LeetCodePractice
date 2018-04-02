package question754;

/**
 * Created by duncan on 18-4-2.
 */
public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.reachNumber(1));
    }
}
