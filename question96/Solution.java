package question96;

/**
 * Created by duncan on 17-11-11.
 */
public class Solution {
    public int numTrees(int n) {
        if(n <= 1)
            return 1;
        int total = 0;
        for(int left =0 ;left < n / 2; left++)
            total += numTrees(left) * numTrees(n-left-1);
        if(n % 2 == 0)
            total *= 2;
        else {
            total *= 2;
            total += (int)Math.pow(numTrees(n/2),2);
        }
        return total;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.numTrees(3));
    }
}
