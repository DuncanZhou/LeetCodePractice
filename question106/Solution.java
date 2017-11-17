package question106;

/**
 * Created by duncan on 17-11-17.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//根据二叉树的中序遍历和后序遍历还原二叉树
public class Solution {
    public TreeNode buildTree(int[] inorder,int[] postorder, int instart, int inend, int poststart, int postend) {
        if(poststart > postend || instart > inend)
            return null;
        int i = instart;
        while(i <= inend){
            if(inorder[i] == postorder[postend])
                break;
            i++;}
        int len = i - instart;
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = buildTree(inorder,postorder,instart,instart + len-1,poststart,poststart + len-1);
        root.right = buildTree(inorder,postorder,instart+len+1,inend,poststart+len,postend-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public void preorder(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        int[] postorder = {6,4,2,7,5,3,1};
        int[] inorder = {4,6,2,1,3,7,5};
        TreeNode root = method.buildTree(inorder,postorder);
        method.preorder(root);
    }
}
