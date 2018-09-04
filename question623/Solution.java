package question623;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        insert(root,v,d,1);
        return root;
    }
    private void insert(TreeNode root,int v,int d,int curd){
        if(root == null || curd > d) return;
        if(curd == d - 1){
            TreeNode ltemp = new TreeNode(v);
            TreeNode rtemp = new TreeNode(v);
            ltemp.left = root.left;
            root.left = ltemp;
            rtemp.right = root.right;
            root.right = rtemp;
            return;
        }
        insert(root.left,v,d,curd+1);
        insert(root.right,v,d,curd+1);
    }
}
