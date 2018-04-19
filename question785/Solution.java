package question785;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by duncan on 18-4-19.
 */
public class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] res = new int[graph.length];
        Arrays.fill(res,-1);
        //两个集合分别用0,1表示
        for(int i = 0; i < graph.length; i++)
            if(res[i] == -1 && !dfs(graph,res,i,0)) return false;
        return true;
    }
    private boolean dfs(int[][] graph,int[] res,int index,int cur){
        /*
        * index:为当前判断的顶点
        * cur: 为当前顶点应该位于的集合
         */
        if(res[index] != -1)
            return res[index] == cur;
        else res[index] = cur;
        for(int next: graph[index]){
            if(!dfs(graph,res,next,1-cur)) return false;
        }
        return true;
    }
//    private boolean helper(int[][] graph,int index,List<HashSet<Integer>> list){
//        if(index == graph.length) return true;
//        boolean res = false;
//        for(int i = 0; i < list.size(); i++){
//            //如果该集合中没有和index相邻的点可以加入该集合
//            boolean flag = true;
//            for(int x : graph[index])
//                if(list.get(i).contains(x)){flag = false;break;}
//            if(flag){
//                list.get(i).add(index);
//                if(helper(graph,index+1,list)) return true;
//                list.get(i).remove((Object)index);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] graph = {{1},{0,3},{3},{1,2}};
        System.out.println(method.isBipartite(graph));
    }
}
