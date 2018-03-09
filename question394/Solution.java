package question394;

import java.util.Stack;

/**
 * Created by duncan on 18-3-9.
 */
public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            //数字入栈
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            //之前的字符串入栈
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            //出栈
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;


//        Stack<Integer> count = new Stack<>();
//        Stack<String> result = new Stack<>();//用Stack处理包含关系
//
//        result.push("");
//        int i = 0;
//
//        while(i<s.length()){
//            char a = s.charAt(i);
//            if(a >= '0' && a <= '9'){
//                int p1 = i;
//                while(Character.isDigit(s.charAt(i+1))) i++;
//                count.push(Integer.parseInt(s.substring(p1,i+1)));
//            } else if (a == '[') {
//                result.push("");//用初始化空字符串处理并列关系
//            } else if(a == ']') {
//                String temp = new String(result.pop());
//                StringBuilder sb = new StringBuilder();
//                int nloop = count.pop();
//                for(int j = 0; j < nloop;j++)
//                    sb.append(temp);
//                result.push(result.pop()+sb.toString());
//            } else {
//                result.push(result.pop()+a);
//            }
//            i++;
//        }
//        return result.pop();
    }
}
