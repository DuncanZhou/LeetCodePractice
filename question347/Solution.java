package question347;

import java.util.*;

/**
 * Created by duncan on 18-2-28.
 */
class Node implements Comparable{
    int val;
    int fre;
    Node(int a,int b){
        val = a;
        fre = b;
    }
    public int compareTo(Object a){
        Node c = (Node)a;
        if(c.fre == fre)
            return 0;
        return c.fre > fre ? 1 : -1;
    }
}
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else map.put(nums[i],map.get(nums[i])+1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> node: map.entrySet()){
            Node temp = new Node(node.getKey(),node.getValue());
            priorityQueue.add(temp);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            Node temp =priorityQueue.poll();
            res.add(temp.val);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,1,1,1,2,2,2,3,3,4};
        List<Integer> res = method.topKFrequent(nums,3);
        for(int r: res)
            System.out.println(r);
    }
}
