package question104;

/**
 * Created by duncan on 17-11-17.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 //求二叉树的最大深度,递归计算
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth,rightdepth) + 1;
    }
}
