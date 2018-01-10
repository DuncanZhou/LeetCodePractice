package question171;

/**
 * Created by duncan on 18-1-10.
 */
public class Solution {
    public int titleToNumber(String s) {
        int res = 0,c = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * (int)Math.pow(26, c);
            c ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "AB";
        System.out.println(method.titleToNumber(str));
    }
}
