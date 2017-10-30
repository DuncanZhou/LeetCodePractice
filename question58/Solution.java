package question58;

/**
 * Created by duncan on 17-10-30.
 */

//返回最后一个单词的长度
public class Solution {
    public int lengthOfLastWord(String s) {
        /*s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;*/

        if(s.length() == 0)
            return 0;
        //从后向前找
        int len = s.length();
        int count = 0;
        //找到不是空格的最后一个字符
        int i = len - 1;
        while(i >= 0) {
            if (s.charAt(i) == ' ')
                i--;
            else
                break;
        }
        if(i < 0)
            return 0;
        for(; i >= 0; i--)
            if(s.charAt(i) != ' ')
                count++;
            else
                return count;
        return count;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.lengthOfLastWord("d adfas "));
    }
}
