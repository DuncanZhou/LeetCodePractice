package question235;

import java.util.*;

/**
 * Created by duncan on 18-1-27.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public List<TreeNode> SearchPath(TreeNode root, TreeNode p){
        List<TreeNode> path = new ArrayList<>();
        TreeNode search = root;
        while(search != null && search != p){
            if(search.val > p.val) {
                path.add(search);
                search = search.left;
            }
            else{path.add(search);search = search.right;}
        }
        path.add(search);
        return path;
    }
    //在二叉搜索树中找到两个结点的最低公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//        if(root.val > p.val && root.val > q.val){
//            return lowestCommonAncestor(root.left, p, q);
//        }else if(root.val < p.val && root.val < q.val){
//            return lowestCommonAncestor(root.right, p, q);
//        }else{
//            return root;
//        }

        //从根结点到p或q都访问一遍,找出共同的元素,如果没有,就是根结点
        List<TreeNode> path1 = SearchPath(root,p);
        List<TreeNode> path2 = SearchPath(root,q);
        //求path1和path2分开的第一个地方
        int i = 0;
        for(; i < Math.min(path1.size(),path2.size()); i++){
            if(path1.get(i) != path2.get(i))
                break;
        }
        if(i == 0)
            return root;
        else
            return path1.get(i-1);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node9 = new TreeNode(9);
//        node6.left = node2;
//        node6.right = node8;
//        node2.left = node0;
//        node2.right = node4;
//        node4.left = node3;
//        node4.right = node5;
//        node8.left = node7;
//        node8.right = node9;
        node2.left = node1;
        node2.right = node3;
        TreeNode res = method.lowestCommonAncestor(node2,node1,node3);
        System.out.println(res.val);
    }
}
