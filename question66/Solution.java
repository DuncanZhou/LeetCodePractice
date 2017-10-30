package question66;

/**
 * Created by duncan on 17-10-30.
 */

//用数组表示的数,对其进行加1操作
public class Solution {
    public int[] plusOne(int[] digits) {
        int extra = 0;
        StringBuilder results = new StringBuilder();
        digits[digits.length - 1] += 1;
        for(int i = digits.length - 1; i >= 0;i--){
            if(digits[i] + extra >= 10)
            {
                results.append(digits[i] + extra - 10);
                extra = 1;
            }
            else {
                results.append(digits[i] + extra);
                extra = 0;
            }
        }
        if(extra == 1)
            results.append(1);
        results.reverse();
        int[] res = new int[results.length()];
        for(int i = 0; i < res.length; i++)
            res[i] = results.charAt(i) - '0';
        return res;
    }

    public static void main(String[] args) {
        Solution method =  new Solution();
        int[] results = method.plusOne(new int[]{8,9,9});
        for(int i = 0; i < results.length; i++)
            System.out.print(results[i] + " ");
    }
}
