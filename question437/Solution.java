package question437;

/**
 * Created by duncan on 18-2-24.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    //二叉树中多少条路径之和为sum
    //递归,二叉树左右子树分别递归
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return pathSumFrom(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    private int pathSumFrom(TreeNode root,int sum){
        if(root == null)
            return 0;
        return ( root.val == sum ? 1 : 0 ) + pathSumFrom(root.left,sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}
