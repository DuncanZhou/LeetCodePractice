package question103;

import java.util.*;

/**
 * Created by duncan on 17-11-17.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//左->右输出再右->左输出,如此交换输出每一层
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //在出队每次判断先加入左孩子还是先加入右节点
        int flag = -1;//-1代表左->右;1表示右->左
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return res;
        queue.add(root);
        int nodes = 1;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            flag *= -1;
            int newnodes = 0;
            for(int i = 0; i < nodes; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if(temp.right != null)
                {   queue.add(temp.right);
                    newnodes++;}
                if(temp.left != null)
                {   queue.add(temp.left);
                    newnodes++;}
            }
            if(flag == 1)
                Collections.reverse(level);
            nodes = newnodes;
            res.add(level);
        }
        return res;
    }
}
