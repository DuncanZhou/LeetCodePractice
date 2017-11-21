package question110;

/**
 * Created by duncan on 17-11-20.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
//计算一棵二叉树是否是平衡树
public class Solution {
    public int Height(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(Height(root.left),Height(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        //计算左子树高度
        return (Math.abs(Height(root.left) - Height(root.right)) > 1 ? false : true) && isBalanced(root.left) && isBalanced(root.right);
    }
}
