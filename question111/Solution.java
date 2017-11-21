package question111;

/**
 * Created by duncan on 17-11-20.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
//找到二叉树的最小深度
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
