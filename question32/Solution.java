package question32;

import java.util.Stack;

/**
 * Created by DuncanZhou on 2016/8/30.
 */
public class Solution {
    public static int longestValidParantheses(String s){
        Stack<Integer> stack = new Stack<Integer>();
        int maxlen = 0,temp = 0,index = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                stack.push(i);
            else
            {
                if(stack.isEmpty()){
                    //重新更新断点
                    index = i;
                }else
                {
                    stack.pop();
                    if(stack.isEmpty())//如果仍然是连续的
                        maxlen = Math.max(i - index,maxlen);
                    else //不连续之后计算当前合法的长度
                        maxlen = Math.max(i - stack.peek(),maxlen);
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args){
        String s = "()(()()";
        System.out.println(longestValidParantheses(s));
    }
}
