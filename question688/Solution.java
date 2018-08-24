package question688;

public class Solution {
    //回溯法超时
    int res = 0;
    public double knightProbability(int N, int K, int r, int c) {
        dfs(N,K,r,c);
        return res * 1.0 / Math.pow(8,K);
    }
    private void dfs(int N, int k, int curx, int cury){
        if(curx < 0 || curx >= N || cury < 0 || cury >= N) return;
        if(k == 0){
            //如果curx和cury还在棋盘内则结果加1
            if(curx >= 0 && curx < N && cury >= 0 && cury < N) res++;
            return;
        }
        //继续跳,8种方向
        dfs(N,k-1,curx-1,cury-2);
        dfs(N,k-1,curx-2,cury-1);
        dfs(N,k-1,curx-2,cury+1);
        dfs(N,k-1,curx-1,cury+2);

        dfs(N,k-1,curx+1,cury+2);
        dfs(N,k-1,curx+2,cury+1);
        dfs(N,k-1,curx+2,cury-1);
        dfs(N,k-1,curx+1,cury-2);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.knightProbability(3,1,1,1));
    }
}
