package question886;


import java.util.*;

public class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //图的着色
        //使用list存储边的关系
        Map<Integer,Set<Integer>> edges = new HashMap<>();
        //初始化
        for(int i = 1; i <= N; i++)
            edges.put(i,new HashSet<>());
        //对dislikes建立边
        for(int[] edge : dislikes){
            edges.get(edge[0]).add(edge[1]);
            edges.get(edge[1]).add(edge[0]);
        }
        int[] color = new int[N+1];
        //对所有点遍历,有多个连通分量，所以要多个点出发判断
        for(int i = 1; i <= N; i++)
            if(color[i] == 0 && !dfs(i,edges,color,1)) return false;
        return true;
    }
    private boolean dfs(int cur,Map<Integer,Set<Integer>> edges,int[] color,int c){
        color[cur] = c;
        for(int node : edges.get(cur)){
            //相邻重复色
            if(color[node] == c) return false;
            //未访问过 dfs搜索
            if(color[node] == 0 && !dfs(node,edges,color,-c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] dislikes = {{1,2},{1,3},{2,3}};
        System.out.println(method.possibleBipartition(4,dislikes));
    }
}
