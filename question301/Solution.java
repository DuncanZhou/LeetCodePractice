package question301;

import java.util.*;

/**
 * Created by duncan on 18-2-27.
 */

// "()())()" -> ["()()()", "(())()"]
public class Solution{
    public void removeInvalidParentheses(String s, Set<String> res, Stack<Character> temp,String cur,int index) {
        if(index == s.length()){
            if(temp.isEmpty())
                res.add(cur);
            else{
                int i;
                for(i = 0; i < cur.length(); i++)
                    if(cur.charAt(i) == '(' || cur.charAt(i) == ')')
                        break;
                if(i == cur.length())
                    res.add(cur);
            }
            return;
        }
        char a = s.charAt(index);
        if(a == ')'){
            if(!temp.isEmpty() && temp.peek() == '(') {
                temp.pop();
                removeInvalidParentheses(s,res,temp,cur+a,index+1);
                temp.add('(');
            }
            removeInvalidParentheses(s,res,temp,cur,index+1);
        }
        else if(a == '('){
            temp.add(a);
            removeInvalidParentheses(s,res,temp,cur+a,index+1);
            temp.pop();
            removeInvalidParentheses(s,res,temp,cur,index+1);
        }else
            removeInvalidParentheses(s,res,temp,cur+a,index+1);
    }
    // 移除最少的括号使得s有效,dfs
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        List<String> results = new ArrayList<String>();
        Stack<Character> temp = new Stack<>();
        removeInvalidParentheses(s,res,temp,"",0);
        int maxlen = 0;
        for(String r : res)
            if(r.length() > maxlen)
                maxlen = r.length();
        for(String r : res)
            if(r.length() == maxlen)
                results.add(r);
        if(results.size() == 0)
            results.add("");
        return results;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String s = "()())()";
        List<String> res = method.removeInvalidParentheses(s);
        for(String r : res)
            System.out.println(r);
    }
}
