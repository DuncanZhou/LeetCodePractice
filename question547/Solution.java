package question547;

/**
 * Created by duncan on 18-5-29.
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++){
            if(!visited[i]) res += dfs(i,M,visited) == true ? 1: 0;
        }
        return res;
    }
    private boolean dfs(int start,int[][] M,boolean[] visited){
        boolean flag = false;
        visited[start] = true;
        for(int j = 0; j < M.length; j++){
            if(!visited[j] && M[start][j] == 1){
                flag |= dfs(j,M,visited);
            }else if(visited[j] && M[start][j] == 1) flag = true;
        }
        return flag;
    }
}
