package question345;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by duncan on 18-1-29.
 */
public class Solution {
    //交换字符串中的元音字母
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0 || s.length() == 1)
            return s;
        Set<Character> vowels = new HashSet<Character>(){{add('a');add('e');add('i');add('o');add('u');add('A');add('E');add('I');add('O');add('U');}};
        int left = 0,right = s.length() - 1;
        char[] res = s.toCharArray();
        while(left < right)
        {
            while(left < right && !vowels.contains(s.charAt(left)))
                left++;
            while(left < right && !vowels.contains(s.charAt(right)))
                right--;
            if(left >= right)
                break;
            //swap
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
        return  String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.reverseVowels("ltdsf"));
    }
}
