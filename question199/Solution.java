package question199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by duncan on 18-1-15.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    //返回每一层最右边的元素
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            level--;
            //加入当前结点的左右孩子
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
            //当该层结点全部弹出,则保留最右的结点值
            if(level == 0) {
                res.add(cur.val);
                level = queue.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
//        node3.right = node5;
//        node5.right = node6;
        Solution method = new Solution();
        List<Integer> res = method.rightSideView(node1);
        for(int i : res)
            System.out.print(i + " ");
    }
}
