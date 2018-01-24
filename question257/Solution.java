package question257;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-1-24.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class Solution {


//    private void searchBT(TreeNode root, String path, List<String> answer) {
//        if (root.left == null && root.right == null) answer.add(path + root.val);
//        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
//        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
//    }


    public void binaryTreePaths(TreeNode root,StringBuilder cur,List<String> res){
        if(root == null)
            return;
        cur.append(root.val);
        cur.append('-');
        cur.append('>');
        if(root.left == null && root.right == null)
        {
            cur.deleteCharAt(cur.length()-1);
            cur.deleteCharAt(cur.length()-1);
            res.add(new String(cur.toString()));
            return;
        }
        StringBuilder next =  new StringBuilder(cur);
        binaryTreePaths(root.left,cur,res);
        binaryTreePaths(root.right,next,res);
    }
    //输出二叉树从根结点到叶子的路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        binaryTreePaths(root,cur,res);
        return res;
    }
}
