package question155;

import java.util.Stack;

/**
 * Created by duncan on 18-1-9.
 */

//以常数时间返回最小的数,也就是在push的时候同时记录最小的数
class MinStack {
    int min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MIN_VALUE;
        stack = new Stack();
    }

    public void push(int x) {
        if(stack.size() == 0)
            min = x;
        else if(x < min)
            min = x;
        stack.push(x);
    }

    public void pop() {
        int val = Integer.MIN_VALUE;
        if(!stack.isEmpty())
            val = stack.pop();
        //如果最小值被弹出,则要重新找到最小值
        if(val == min){
            int res = Integer.MAX_VALUE;
            //在stack中重新找到最小值
            Stack<Integer> tempStack = new Stack<>();
            while(!stack.isEmpty()){
                int temp = stack.pop();
                if(temp < res)
                    res = temp;
                tempStack.push(temp);
            }
            while(!tempStack.isEmpty())
                stack.push(tempStack.pop());
            min = res;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
public class Solution {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
