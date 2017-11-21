package question112;

/**
 * Created by duncan on 17-11-20.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && sum == root.val)
            return true;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
