package question125;

/**
 * Created by duncan on 17-12-6.
 */
public class Solution {
    //判断字符串是否是回文字符串
    public boolean isPalindrome(String s) {
        int start = 0,end = s.length() - 1;
        while(start <= end){
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start)))
                start++;
            while (end >= start && !Character.isLetterOrDigit(s.charAt(end)))
                end--;
            if(start > end)
                return true;
            if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end)))
            {
                start++;
                end--;
            }else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.isPalindrome("0P"));
    }
}
