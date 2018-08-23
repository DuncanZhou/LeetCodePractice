package question617;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    //值相加
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = t1;
        if(t2 != null) {
            if(root == null) return t2;
            root.val += t2.val;
            //左右子树
            root.left = mergeTrees(root.left,t2.left);
            root.right = mergeTrees(root.right,t2.right);
        }
        return root;
    }
}
