package question100;

/**
 * Created by duncan on 17-5-5.
 */

import sun.reflect.generics.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Solution {
    //判断两颗二叉树是否完全相等,前序遍历
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //选择一种遍历方式遍历两颗树
        //判断每个节点的值是否相等
        if(p == null && q == null)
            return true;
        if(p != null && q != null){
            if(p.val == q.val) {
                boolean left = isSameTree(p.left, q.left);
                boolean right = isSameTree(p.right, q.right);
                if (left == true && right == true)
                    return true;
                else
                    return false;
            }
            else
                return false;
        }else
            return false;
    }

    public static void main(String[] args) {

    }
}
