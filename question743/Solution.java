package question743;

import java.util.Arrays;

/**
 * Created by duncan on 18-3-30.
 */
public class Solution {
    //从k出发到所有结点最短路径,如果可以返回最短路径,否则返回-1
    public int networkDelayTime(int[][] times, int N, int K) {
        //构造有向图
        //dfs
        int[][] matrix = Construct(times,N);
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        dijsktra(matrix,K,N,visited,dist);
        int i;
        for (i = 1; i <= N; i++)
            if(!visited[i]) break;
        if(i != N + 1) return -1;
        int max = -1;
        for(i = 1; i <= N; i++)
            if(dist[i] > max) max = dist[i];
        return max;
    }
    //构造有向图的邻接矩阵
    private int[][] Construct(int[][] times,int N){
        int[][] matrix = new int[N+1][N+1];
        for(int i = 0; i <= N; i++)
            Arrays.fill(matrix[i],-1);
        for(int[] time : times)
            matrix[time[0]][time[1]] = time[2];
        for(int i = 1; i<= N; i++)
            matrix[i][i] = 0;
        return matrix;
    }
    //迪杰斯特拉找最长的一条路径
    private void dijsktra(int[][] matrix,int source,int N,boolean[] visited,int[] dist){
        visited[source] = true;
        //初始化dist
        for(int i = 1; i <= N; i++)
            dist[i] = matrix[source][i] != -1 ? matrix[source][i] : Integer.MAX_VALUE;

        int to_add;
        do {
            to_add = 0;
            //从剩下的点中找到和source相连最近的点
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && dist[i] < min) {
                    to_add = i;
                    min = dist[i];
                }
            }
            if (to_add == 0) return;
            visited[to_add] = true;
            //更新dist
            for(int i = 1; i <= N; i++){
                if(!visited[i] && matrix[to_add][i] != -1 && matrix[to_add][i] + dist[to_add] < dist[i])
                    dist[i] = matrix[to_add][i] + dist[to_add];
            }
        }while (to_add != 0);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(method.networkDelayTime(times,4,2));
    }
}
