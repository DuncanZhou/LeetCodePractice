package question214;

/**
 * Created by duncan on 18-1-18.
 */
public class Solution {
    //求第一次出现的最长回文前缀
    public String shortestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 0) return "";
        char[] sa = s.toCharArray();
        char[] ma = new char[sa.length*2+1];
        ma[0] = '#';
        for(int i=0, j=1; i<sa.length; i++, j+=2) {
            ma[j] = sa[i];
            ma[j+1] = '#';
        }
        int m = ma.length/2;
        int[] radius = new int[ma.length];
        int rightmost = 1;
        int center = 1;
        int patch = sa.length - 1;
        for(int i=1; i<=ma.length/2; i++) {
            int min = rightmost <= i ? 1 : Math.min(rightmost-i, radius[center - (i -center)]) + 1;
            for(int r=min; i-r>=0; r++) {
                if (ma[i-r] != ma[i+r]) break;
                radius[i] = r;
                if (i-r==0) patch = sa.length - i;
            }
            if (rightmost < i+radius[i]) {
                rightmost = i + radius[i];
                center = i;
            }
        }
        char[] palindrome = new char[sa.length + patch];
        for(int j=0, k=sa.length-1; j<patch; j++, k--) palindrome[j] = sa[k];
        System.arraycopy(sa, 0, palindrome, patch, sa.length);
        return new String(palindrome);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.shortestPalindrome("aabba"));
    }
}
