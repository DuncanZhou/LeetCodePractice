package question783;

import java.util.Comparator;
import java.util.PriorityQueue;



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public int minDiffInBST(TreeNode root) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b - a;
            }
        });
        Preorder(root,queue);
        int min = Integer.MAX_VALUE;
        int a = queue.poll();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(a - cur < min) min = a - cur;
            a = cur;
        }
        return min;
    }
    //遍历
    private void Preorder(TreeNode root,PriorityQueue<Integer> queue){
        if(root == null) return;
        queue.add(root.val);
        Preorder(root.left,queue);
        Preorder(root.right,queue);
    }
}
