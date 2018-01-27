package question230;

import java.util.Stack;

/**
 * Created by duncan on 18-1-27.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    //写一个函数找到二叉树中第k个最小的数(假设k小于二叉树的结点数)
    //尝试使用中序遍历
    public void kthSmallest(TreeNode root, int k, Stack<Integer> res) {
        if(root == null)
            return;
        //左根右
        if(res.size() == k)
            return;
        kthSmallest(root.left,k,res);
        if(res.size() == k)
            return;
        res.push(root.val);
        kthSmallest(root.right,k,res);
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<Integer> res = new Stack<>();
        kthSmallest(root,k,res);
        return res.pop();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.left = node2;
        node2.left = node1;
        node3.right = node4;
        node4.right = node5;
        System.out.println(method.kthSmallest(node3,5));
    }
}
