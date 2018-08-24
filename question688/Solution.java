package question688;

import java.util.Arrays;

public class Solution {
    //回溯法超时
    int res = 0;
    public double knightProbability(int N, int K, int r, int c) {
//        dfs(N,K,r,c);
//        return res * 1.0 / Math.pow(8,K);

        //动态规划解决
        int[][] moves = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        double[][] dp0 = new double[N][N];
        for(int i = 0; i < dp0.length; i++) Arrays.fill(dp0[i],1);
        for(int step = 0; step < K; step++){
            double[][] dp1 = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int[] move : moves){
                        int x = i + move[0];
                        int y = j + move[1];
                        if(x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp1[i][j] += dp0[x][y];
                    }
                }
            }
            dp0 = dp1;
        }
        return dp0[r][c] / Math.pow(8,K);
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
