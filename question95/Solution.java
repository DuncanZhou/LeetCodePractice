package question95;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-10.
 */

//输出所有结构唯一的二叉树结果
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return generateSubTree(1, n);
    }
    public ArrayList<TreeNode> generateSubTree(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int rootVal = start; rootVal <= end; rootVal++)
            for (TreeNode leftSubTreeRoot : generateSubTree(start, rootVal - 1))
                for (TreeNode rightSubTreeRoot : generateSubTree(rootVal + 1, end)) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftSubTreeRoot;
                    root.right = rightSubTreeRoot;
                    result.add(root);
                }
        return result;
    }
    public void traverse(TreeNode root){
        if(root != null)
        {
            System.out.print(root.val + " ");
            traverse(root.left);
            traverse(root.right);
        }else {
            System.out.print("null ");
            return;
        }
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        List<TreeNode> res = method.generateTrees(3);
        for(TreeNode cur: res) {
            method.traverse(cur);
            System.out.println();
        }
    }
}
