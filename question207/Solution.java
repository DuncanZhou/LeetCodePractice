package question207;

import java.util.*;

/**
 * Created by duncan on 18-1-17.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> edges = new HashMap<>();
        List<Integer> empty = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            edges.put(i, new ArrayList<>());
            empty.add(i);
        }
        //加入
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> temp = edges.get(prerequisites[i][0]);
            temp.add(prerequisites[i][1]);
            edges.put(prerequisites[i][0],temp);
            empty.remove((Object)prerequisites[i][0]);
        }
        Set<Integer> res = new HashSet<>();
        //从empty中移除
        while(!empty.isEmpty()){
            int temp = empty.get(0);
            empty.remove(0);
            res.add(temp);
            if(res.size() == numCourses)
                return true;
            //从edges中移除依赖temp的元素
            for(Map.Entry<Integer,List<Integer>> item:edges.entrySet()){
                List<Integer> depend = item.getValue();
                if(depend.contains(temp))
                    depend.remove((Object)temp);
                if(depend.size() == 0) {
                    if(!res.contains(item.getKey())) {
                        empty.add(item.getKey());
                        res.add(item.getKey());
                    }
                }
            }
        }
        if(res.size() == numCourses)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] courses = {{1,0}};
        System.out.println(method.canFinish(2,courses));
    }
}
