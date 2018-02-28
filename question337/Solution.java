package question337;

/**
 * Created by duncan on 18-2-28.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int res1 = rob(root.left) + rob(root.right);
        int res2 = root.val;
        if(root.left != null) {
            res2 += rob(root.left.left);
            res2 += rob(root.left.right);
        }
        if(root.right != null){
            res2 += rob(root.right.left);
            res2 += rob(root.right.right);
        }
        return Math.max(res1,res2);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(method.rob(node1));
    }
}
