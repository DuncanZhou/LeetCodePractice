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
        //如果root为空树或者等于其中一个则直接返回
        if(root == null || root == p || root == q) return root;
        //分三种情况,
        // 1.p,q都处于root左子树
        // 2.p,q都处于root右子树
        // 3.p,q分别位于root左右子树
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //p,q位于两颗不同子树
        if(left != null && right != null) return root;
        //p,q处于同一颗树中
        return left == null ? right : left;
//        List<TreeNode> ppath = new ArrayList<>();
//        List<TreeNode> qpath = new ArrayList<>();
//        Search(root,p,ppath,new ArrayList<>());
//        Search(root,q,qpath,new ArrayList<>());
//        //寻找ppath和qpath前半段相同处
//        int i;
//        for(i = 0; i < Math.min(ppath.size(),qpath.size()); i++)
//            if(ppath.get(i) != qpath.get(i)) break;
//        return ppath.get(i-1);
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
        //左子树已经找到,无须再在右子树找
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
