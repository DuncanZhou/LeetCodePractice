package question739;

import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] res = new int[days];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < days; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
                res[stack.peek()] = i - stack.pop();
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(method.dailyTemperatures(temperatures)));
    }
}
