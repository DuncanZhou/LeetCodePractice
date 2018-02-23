package question404;

import java.util.Stack;

/**
 * Created by duncan on 18-2-23.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    //求二叉树所有左叶子结点的和
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left != null)
            {
                if(temp.left.left == null && temp.left.right == null)
                    sum += temp.left.val;
                else stack.push(temp.left);
            }
            if(temp.right != null)
                stack.push(temp.right);
        }
        return sum;
    }
}
