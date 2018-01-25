package question129;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-12-19.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {


    //简介版答案
//    public int sumNumbers(TreeNode root) {
//        return sum(root, 0);
//    }
//
//    public int sum(TreeNode n, int s){
//        if (n == null) return 0;
//        if (n.right == null && n.left == null) return s*10 + n.val;
//        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
//    }


    public void sumNumbers(TreeNode root,List<Integer> res,StringBuilder cur) {
        if(root == null)
            return;
        StringBuilder next = new StringBuilder(cur);
        next.append(root.val);
        if(root.left == null && root.right == null)
            res.add(Integer.parseInt(next.toString()));
        if(root.left != null)
            sumNumbers(root.left,res,next);
        if(root.right != null)
            sumNumbers(root.right,res,next);
    }
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        sumNumbers(root,res,cur);
        int sum = 0;
        for(int num:res)
            sum += num;
        return sum;
    }

    //打印根节点到叶子节点路径(C++代码)
//    void findPath(BinaryTreeNode*pRoot,vector<int>&path,int nToFind){
//        if (pRoot==NULL)
//        {
//            return;
//        }
//        path.push_back(pRoot->m_nValue);
//        if (pRoot->m_nValue==nToFind) //达到了子节点
//        {
//            printPath(path);
//            return;      //找到了就返回，不需要再找了
//        }
//        if (pRoot->m_pLeft != NULL)//左子树
//        {
//            findPath(pRoot->m_pLeft, path,nToFind);
//        }
//        if (pRoot->m_pRight != NULL)//右子树
//        {
//            findPath(pRoot->m_pRight, path,nToFind);
//        }
//        path.pop_back();//在返回到父节点之前，在路径上删除当前节点
//    }
    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        System.out.println(method.sumNumbers(node1));
    }
}
