package question107;

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
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> res = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return res;
        //nodes记录每一层节点数
        int nodes = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> values = new ArrayList<>();
            int newnodes = 0;
            //弹出nodes个
            for(int i = 0; i < nodes; i++)
            {
                TreeNode temp = queue.poll();
                values.add(temp.val);
                //弹出的元素的左右节点加入队列
                if(temp.left != null) {
                    queue.add(temp.left);
                    newnodes++;
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                    newnodes++;
                }
            }
            res.add(values);
            nodes = newnodes;
        }
        //弹出栈中
        List<List<Integer>> result = new ArrayList<>();
        while(!res.isEmpty()){
            List<Integer> temp = res.pop();
            result.add(temp);
        }
        return result;
    }
}
