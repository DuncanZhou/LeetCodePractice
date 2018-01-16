package question204;

/**
 * Created by duncan on 18-1-16.
 */
public class Solution {
    public int countPrimes(int n) {
        //厄拉多塞筛法
        boolean[] m = new boolean[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (m[i])
                continue;

            count++;
            for (int j=i; j<n; j=j+i)
                m[j] = true;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.countPrimes(3));
    }
}
