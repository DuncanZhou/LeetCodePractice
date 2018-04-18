package question652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by duncan on 18-4-18.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
//寻找二叉树中重复的子树,子树具有相同的结构和结点值
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> map = new HashMap<>();
        List<TreeNode> results = new ArrayList<>();
        Search(results,root,map);
        return results;
    }
    //先序遍历并建立map
    private String Search(List<TreeNode> results, TreeNode root, HashMap<String,Integer> map){
        if(root == null) return "#";
        String serial = root.val + "," + Search(results,root.left,map) + "," + Search(results,root.right,map);
        if(map.getOrDefault(serial,0) == 1) results.add(root);
        map.put(serial,map.getOrDefault(serial,0)+1);
        return serial;
    }
}
