package question105;



/**
 * Created by duncan on 17-11-17.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder,int prestart,int preend,int instart,int inend) {
        if(prestart > preend || instart > inend)
            return null;
        //寻找root
        int i = instart;
        while (i <= inend) {
            if (inorder[i] == preorder[prestart])
                break;
            i++;
        }
        int len = i - instart;
        TreeNode root = new TreeNode(preorder[prestart]);
        //构造左子树和右子树
        root.left = buildTree(preorder,inorder,prestart+1,prestart+len,instart,instart+len-1);
        root.right = buildTree(preorder,inorder,prestart+len+1,preend,instart+len+1,inend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
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
        int[] preorder = {1,2,4,6,3,5,7};
        int[] inorder = {4,6,2,1,3,7,5};
        TreeNode root = method.buildTree(preorder,inorder);
        method.preorder(root);
    }
}
