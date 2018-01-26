package question223;

/**
 * Created by duncan on 18-1-26.
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //先计算两个矩形的面积之和,然后减去两个矩形的交叠部分
        int s1 = Math.abs(A - C) * Math.abs(B - D);
        int s2 = Math.abs(E - G) * Math.abs(H - F);
        int res = s1 + s2;
        //无交集
        if(E >= C || H <= B || G <= A || F >= D)
            return res;
        //包含关系
        if(A <= E && B <= F && C >= G && D >= H)
            return s1;
        if(E <= A && F <= B && G >= C && H >= D)
            return s2;
        //有交集(四种)
        int intersection = (Math.min(G,C) - Math.max(A,E)) * (Math.min(H,D) - Math.max(F,B));
        return res - intersection;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.computeArea(-2,-2,2,2,-4,3,-3,4));
    }
}
