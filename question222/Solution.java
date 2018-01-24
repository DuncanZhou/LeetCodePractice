package question222;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by duncan on 18-1-24.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public int countNodes(TreeNode root) {

        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        //如果是左右子树高度相等,则是满二叉树
        if (leftDepth == rightDepth)
            return (1 << leftDepth) - 1;
        else
            //否则递归计算左子树和右子树结点,然后+1
            return 1+countNodes(root.left) + countNodes(root.right);

    }

    private int rightDepth(TreeNode root) {
        // TODO Auto-generated method stub
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        // TODO Auto-generated method stub
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }
}
