package question654;



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int maxIndex = start, maxNum = nums[start];
        for(int i = start; i <= end; i++){
            if(nums[i] > maxNum){
                maxIndex = i;
                maxNum = nums[i];
            }
        }
        //建立根节点
        TreeNode root = new TreeNode(maxNum);
        //建立左子树和右子树
        root.left = constructMaximumBinaryTree(nums,start,maxIndex-1);
        root.right = constructMaximumBinaryTree(nums,maxIndex+1,end);
        return root;
    }
}
