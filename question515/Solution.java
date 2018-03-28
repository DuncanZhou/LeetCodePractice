package question515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by duncan on 18-3-28.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lcount = 1,max = Integer.MIN_VALUE,cur = 0,nextlevel = 0;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null){
                queue.add(temp.left);
                nextlevel ++;
            }
            if(temp.right != null){
                queue.add(temp.right);
                nextlevel++;
            }
            if(temp.val > max) max = temp.val;
            cur ++;
            if(lcount == cur){
                //重新计算下一层
                res.add(max);
                max = Integer.MIN_VALUE;
                lcount = nextlevel;
                nextlevel = 0;
                cur = 0;
            }
        }
        return res;
    }
}
