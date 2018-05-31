package question543;

/**
 * Created by duncan on 18-5-31.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int tmp = helper(root);
        return diameter == 0 ? 0 : diameter - 1;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int leftPathLen = helper(root.left);
        int rightPathLen = helper(root.right);
        diameter = Math.max(diameter, leftPathLen + rightPathLen + 1);
        return Math.max(leftPathLen, rightPathLen) + 1;
    }
}
