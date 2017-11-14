package question87;

import java.util.Arrays;

/**
 * Created by duncan on 17-11-14.
 */
//比较两个字符串是否是scramble,递归并减枝
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if(s1.equals(s2))
            return true;

        //比较字符串的字符是否相同
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i = 0;i<length;i++)
            if(chars1[i]!=chars2[i])
                return false;

        //递归判断选择切割点
        boolean res = false;
        for(int i = 1;i<length;i++){
            res = res||(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                    ||(isScramble(s1.substring(0,i),s2.substring(length-i)) && isScramble(s1.substring(i),s2.substring(0,length-i)));
            if(res == true)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str.substring(2));
    }
}
