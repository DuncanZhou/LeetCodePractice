package question227;

import java.util.Stack;

/**
 * Created by duncan on 18-1-26.
 */
public class Solution {
    //实现一个简单的计算器(包含+,-,*,/),对于除数为0报错
    //做繁琐了,应该直接将"-num"作为数压入操作数栈
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        while (i < s.length())
        {
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int num = 0;
            if(Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    //先读取数字
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                if(!operators.isEmpty() && ( operators.peek() == '*' || operators.peek() == '/')){
                    int a = nums.pop();
                    char operator = operators.pop();
                    if(operator == '*')
                        nums.push(a * num);
                    else
                        nums.push(a / num);
                }
                else
                    nums.push(num);
            }
            else {
                operators.push(s.charAt(i));
                i++;
            }
        }
        Stack<Character> operators1 = new Stack<>();
        Stack<Integer> nums1 = new Stack<>();
        while(!operators.isEmpty())
            operators1.push(operators.pop());
        while(!nums.isEmpty())
            nums1.push(nums.pop());
        //开始将操作符栈和操作数栈弹出运算
        while(!operators1.isEmpty()){
            char operator = operators1.pop();
            int a = nums1.pop();
            int b = nums1.pop();
            if(operator == '+')
                nums1.push(a+b);
            else
                nums1.push(a-b);
        }
        return nums1.isEmpty() ? 0 : nums1.pop();
    }

    public static void main(String[] args) {

        Solution method = new Solution();
        System.out.println(method.calculate("1-1+1"));
    }
}
