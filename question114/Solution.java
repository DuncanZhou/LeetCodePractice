package question114;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by duncan on 17-11-21.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    //前序遍历
    public void flatten(TreeNode root, Queue<Integer> queue) {
        if(root == null)
            return;
        queue.add(root.val);
        flatten(root.left,queue);
        flatten(root.right,queue);
    }
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Queue<Integer> queue = new LinkedList<>();
        flatten(root,queue);
        TreeNode newRoot = new TreeNode(0);
        TreeNode cur = newRoot;
        while (!queue.isEmpty()){
            cur.right = new TreeNode(queue.poll());
            cur = cur.right;
        }
        root.left = null;
        root.right = newRoot.right.right;
    }
    //前序遍历
    public void preorder(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        Solution method = new Solution();
        method.flatten(node1);
        method.preorder(node1);
    }
}
