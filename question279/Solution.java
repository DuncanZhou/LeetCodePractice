package question279;

/**
 * Created by duncan on 18-1-30.
 */
public class Solution {
    int res;
    //递归超时
//    public void dfs(int n,int count){
//        int k = (int) Math.sqrt(n);
//        if(k*k==n && count + 1 < res)
//        {
//            count++;
//            res = count;
//            return;
//        }
//        for(int i = k; i >= 1; i--)
//            dfs(n-i*i,count+1);
//    }
    // 计算n需要多少个平方数相加得到
    public int numSquares(int n) {
//        res = n;
//        dfs(n,0);
//        return res;
        int count = n;
        int nearest = (int)Math.sqrt(n);
        if(n == 0) return 0;
        if(nearest*nearest == n) return 1;
        for(int i = nearest; i >= 1; i--) {
            int cur = 0, num  = n, t = i*i;
            while(num - t >= 0) {
                num -= t;
                cur++;
            }
            if(cur < count)
                count = Math.min(numSquares(num)+cur, count);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.numSquares(13));
    }
}
