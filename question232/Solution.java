package question232;

import java.util.Stack;

/**
 * Created by duncan on 18-1-23.
 */

//使用栈实现队列
class MyQueue {

    Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //返回栈底元素
        Stack<Integer> stack1 = new Stack<>();
        while(!stack.isEmpty()){
            if(stack.size() == 1)
                break;
            stack1.push(stack.pop());
        }
        int res = stack.pop();
        while(!stack1.isEmpty())
            stack.push(stack1.pop());
        return res;
    }

    /** Get the front element. */
    public int peek() {
        //返回栈底元素
        Stack<Integer> stack1 = new Stack<>();
        while(!stack.isEmpty()){
            if(stack.size() == 1)
                break;
            stack1.push(stack.pop());
        }
        int res = stack.pop();
        stack1.push(res);
        while(!stack1.isEmpty())
            stack.push(stack1.pop());
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

public class Solution {
}
