package question210;

import java.util.*;

/**
 * Created by duncan on 18-1-19.
 */
public class Solution {
    //拓扑排序,返回遍历的顺序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //定义一个数组来存储结点依赖个数
        int[] depend = new int[numCourses];
        //定义个链表,存储结点访问次序
        Set<Integer> res = new HashSet<>();
        int[] results = new int[numCourses];
        Queue<Integer> tovisit = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++)
            depend[prerequisites[i][0]]++;
        //找出有没有度为0的
        for(int i = 0; i < numCourses; i++)
            if(depend[i] == 0)
                tovisit.add(i);
        if(tovisit.size() == 0)
            return new int[0];
        int index = 0;
        while(!tovisit.isEmpty()){
            int learn = tovisit.poll();
            if(!res.contains(learn)) {
                res.add(learn);
                results[index++] = learn;
            }
            //将依赖learn的课程度都减1
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == learn && !res.contains(prerequisites[i][0])) {
                    depend[prerequisites[i][0]]--;
                    if(depend[prerequisites[i][0]] == 0) {
                        tovisit.add(prerequisites[i][0]);
                        res.add(prerequisites[i][0]);
                        results[index++] = prerequisites[i][0];
                    }
                }
            }
        }
        if(res.size() == numCourses)
            return results;
        else
            return new int[0];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] prerequisites = {};
        System.out.println(Arrays.toString(method.findOrder(0,prerequisites)));
    }
}
