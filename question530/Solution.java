package question530;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-4-11.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    static final int INF = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<>();
        Inorder(root,vals);
        int min = INF,cur = vals.get(0);
        for(int i = 1; i < vals.size(); i++){
            int next = vals.get(i);
            if(Math.abs(next - cur) < min)
                min = Math.abs(next - cur);
            cur = next;
        }
        return min;
    }
    //中序遍历,左根右
    private void Inorder(TreeNode root, List<Integer> vals){
        if(root == null) return;
        Inorder(root.left,vals);
        vals.add(root.val);
        Inorder(root.right,vals);
    }
}
