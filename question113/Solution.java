package question113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-21.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
//判断路径上数之和,输出路径
public class Solution {
    public void pathSum(TreeNode root, int sum, List<List<Integer>> res,List<Integer> cur){


//        path.push(root.val);
//        if(root.left == null && root.right == null)
//            if(sum == root.val) resultList.add(new ArrayList<Integer>(path));
//        if(root.left!=null) pathSumInner(root.left, sum-root.val, path);
//        if(root.right!=null)pathSumInner(root.right, sum-root.val, path);
//        path.pop();

        if(root == null)
            return;
        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList(cur));
            cur.remove(cur.size()-1);
            return;
        }else {
            pathSum(root.left, sum - root.val, res, cur);
            pathSum(root.right, sum - root.val, res, cur);
        }
        cur.remove(cur.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSum(root,sum,res,cur);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node6;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        Solution method = new Solution();
        System.out.println(method.pathSum(root,19));
    }
}
