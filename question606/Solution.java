package question606;

/**
 * Created by duncan on 18-4-18.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder("");
        if(t == null) return res.toString();
        Preorder(t,res,null);
        return res.toString().substring(1,res.length()-1);
    }
    //先序遍历
    private void Preorder(TreeNode root,StringBuilder res,TreeNode last){
        if(root == null) return;
        if(last != null && root == last.right && last.left == null) res.append("()");
        res.append("(");
        res.append(root.val);
        Preorder(root.left, res,root);
        Preorder(root.right, res,root);
        res.append(")");
    }
}
