package question108;

/**
 * Created by duncan on 17-11-17.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//将有序数组构造成平衡二叉树
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {
        if(start > end)
            return null;
        //选取中间元素,以中间元素作为根节点,左边插入左边,右边插入右边
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public void preorder(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        method.preorder(method.sortedArrayToBST(new int[]{1,2,3,4,5,6}));
    }
}
