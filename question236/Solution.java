package question236;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-4-17.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        List<TreeNode> qpath = new ArrayList<>();
        Search(root,p,ppath,new ArrayList<>());
        Search(root,q,qpath,new ArrayList<>());
        //寻找ppath和qpath前半段相同处
        int i;
        for(i = 0; i < Math.min(ppath.size(),qpath.size()); i++)
            if(ppath.get(i) != qpath.get(i)) break;
        return ppath.get(i-1);
    }
    private void Search(TreeNode root,TreeNode target,List<TreeNode> res,List<TreeNode> cur){
        if(root == null || root == target){
            if(root == target) {
                cur.add(target);
                res.addAll(cur);
            }
            return;
        }
        cur.add(root);
        Search(root.left,target,res,cur);
        if(res.size() != 0) return;
        Search(root.right,target,res,cur);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        System.out.println(method.lowestCommonAncestor(root,node1,node6).val);
    }
}
