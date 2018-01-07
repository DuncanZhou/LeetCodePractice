package question158;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by duncan on 18-1-7.
 */
public class Solution {
    //后缀表达式
    public int evalRPN(String[] tokens) {
        //定义操作数栈
        Stack<Integer> nums = new Stack<>();
        Set<String> operators = new HashSet<String>(){{add("+");add("-");add("*");add("/");}};
        for(int i = 0; i < tokens.length; i++){
            if(!operators.contains(tokens[i]))
                nums.push(Integer.valueOf(tokens[i]));
            else{
                //弹出栈内两个元素,运算完后再压入栈内
                int num2 = nums.pop();
                int num1 = nums.pop();
                int num3 = 0;
                switch (tokens[i]){
                    case "+": num3 = num1 + num2;break;
                    case "-": num3 = num1 - num2;break;
                    case "*": num3 = num1 * num2;break;
                    case "/": num3 = num1 / num2;break;
                }
                nums.push(num3);
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(method.evalRPN(tokens));
    }
}
