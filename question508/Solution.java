package question508;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duncan on 18-6-4.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sum(root, sumFreq);
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for(Map.Entry<Integer, Integer> e : sumFreq.entrySet()){
            if(max <= e.getValue()){
                if(max < e.getValue())
                    res.clear();
                res.add(e.getKey());
                max = e.getValue();
            }
        }
        int[] top = new int[res.size()];
        int i=0;
        for(int n : res)
            top[i++] = n;
        return top;
    }
    private int sum(TreeNode curr, Map<Integer, Integer> sumFreq){
        if(curr.left == null && curr.right == null) {
            sumFreq.put(curr.val, sumFreq.getOrDefault(curr.val, 0)+1);
            return curr.val;
        }
        int l=0, r=0, sum=0;
        if(curr.left != null)
            l = sum(curr.left, sumFreq);
        if(curr.right != null)
            r = sum(curr.right, sumFreq);
        sum = l+r+curr.val;
        sumFreq.put(sum, sumFreq.getOrDefault(sum, 0)+1);
        return sum;
    }
}
