package question42;

/**
 * Created by DuncanZhou on 2016/9/10.
 */
public class Solution {
    public int trap(int[] height){
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int start = 0;
        int end = height.length - 1;
        //minheight记录两边最小的高度
        int minheight = Math.min(height[start], height[end]);
        //start end 记录最右边和最左边的位置
        //height记录当前的高度，每次移动一位，更新最大的盛水量。
        while (start < end) {
            if (height[start] < height[end]) {
                res += Math.max(minheight - height[start+1], 0);
                minheight = Math.max(minheight, Math.min(height[start+1], height[end]));
                ++start;
            }
            else {
                res += Math.max(minheight - height[end-1], 0);
                minheight = Math.max(minheight, Math.min(height[start], height[end-1]));
                --end;
            }
        }
        return res;
    }
}
