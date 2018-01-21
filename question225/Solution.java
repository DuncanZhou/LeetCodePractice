package question225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by duncan on 18-1-21.
 */


//使用队列实现栈

class MyStack {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //弹出队列中最后面的
        int size = queue.size(),i = 0;
        while(i < size - 1){
            int temp = queue.poll();
            queue.add(temp);
            i++;
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        int size = queue.size(),i = 0;
        while(i < size - 1){
            int temp = queue.poll();
            queue.add(temp);
            i++;
        }
        int res = queue.poll();
        queue.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}


public class Solution {
}
