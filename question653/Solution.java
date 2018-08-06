package question653;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    //查找二分搜索树中是否有两个元素和为k
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        InorderTraverse(root,nums);
        int start = 0 , end = nums.size() - 1;
        while(start < end){
            int temp = nums.get(start) + nums.get(end);
            if(temp == k) break;
            if(temp < k) start++;
            else end--;
        }
        if(start < end) return true;
        else return false;
    }
    private void InorderTraverse(TreeNode root, List<Integer> nums){
        if(root == null) return;
        InorderTraverse(root.left,nums);
        nums.add(root.val);
        InorderTraverse(root.right,nums);
    }
}
