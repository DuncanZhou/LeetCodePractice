package question151;

import question1.Sloution;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by duncan on 18-1-9.
 */
public class Solution {
    //倒序s中的单词
    public String reverseWords(String s) {
        if(s.length() == 0)
            return s;
        String[] res = s.split(" ");
        if(res.length == 0)
            return "";
        Stack<String> stack = new Stack<>();
        for(String str:res) {
            if(!str.equals(""))
            stack.push(str);
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
            result += stack.size() == 0 ? "" : " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = " 1";
        System.out.println(method.reverseWords(str));
    }
}
