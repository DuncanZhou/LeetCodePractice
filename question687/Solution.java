package question687;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        Length(root,root.val);
        return max;
    }
    private int Length(TreeNode root,int pre){
        if(root == null) return 0;
        int left = Length(root.left,root.val);
        int right = Length(root.right,root.val);
        max = Math.max(max,left+right);
        if(root.val == pre) return Math.max(left,right) + 1;
        else return 0;
    }
}
