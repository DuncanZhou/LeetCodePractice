package question98;

import java.util.Stack;

/**
 * Created by duncan on 17-11-14.
 */


//判断是不是二分搜索树
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
//递归判断,最后结果为左&右
public class Solution {

//    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//        if (root == null) return true;
//        if (root.val >= maxVal || root.val <= minVal) return false;
//        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
//    }

    public boolean inorder(TreeNode root, Stack<Integer> stack){
        //中序遍历,left->root->right
        boolean left = true,right = true;
        if(root != null){
            left = inorder(root.left,stack);
            if(!stack.isEmpty() && root.val <= stack.peek())
                return false;
            else
                stack.push(root.val);
            right = inorder(root.right,stack);
        }
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        return inorder(root,stack);
    }
}
