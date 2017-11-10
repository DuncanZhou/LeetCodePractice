package question94;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-9.
 */

//中序遍历,left-> root -> right
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public void inorder(TreeNode root, List<Integer> res){
        if(root != null){
                inorder(root.left,res);
                res.add(root.val);
                inorder(root.right,res);
        }else
            return;
    }
    public List<Integer> inorderTraversal(TreeNode root) {

//        List<Integer> list = new ArrayList<Integer>();
//
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode cur = root;
//
//        while(cur!=null || !stack.empty()){
//            while(cur!=null){
//                stack.add(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            list.add(cur.val);
//            cur = cur.right;
//        }
//
//        return list;


        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
}
