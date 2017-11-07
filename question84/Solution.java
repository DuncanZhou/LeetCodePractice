package question84;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by duncan on 17-11-7.
 */

// dp[i,j] = max{dp[i+1,j],dp[i,j-1]} + min{nums[i:j]}
public class Solution {
    public int largestRectangleArea(int[] heights) {
        //超时
//        int num = heights.length;
//        int end;
//        if(num < 1) {
//            if(num == 0)
//                return 0;
//            return heights[0];
//        }
//        int max = heights[0];
//        for(int step = 0; step < num; step++){
//            for(int start = 0; start + step < num; start++) {
//                end = start + step;
//                int min = heights[start];
//                for(int i = start; i <= end; i++)
//                    if(heights[i] < min)
//                        min = heights[i];
//                if((step + 1) * min > max)
//                    max = (step + 1) * min;
//            }
//        }
//        return max;

        //对于每一个元素都有一个左边界和右边界,右边界是i,左边界是栈顶元素
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
