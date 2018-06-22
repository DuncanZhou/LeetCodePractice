package question538;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        Traverse(root);
        return root;
    }
    private void Traverse(TreeNode root){
        if(root == null) return;
        Traverse(root.right);
        root.val += sum;
        sum = root.val;
        Traverse(root.left);
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        TreeNode res = method.convertBST(node1);

    }
}
