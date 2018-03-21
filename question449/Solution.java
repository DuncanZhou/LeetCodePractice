package question449;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-3-21.
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        Preorder(root,res);
        String results = "";
        for(int i = 0; i < res.size(); i++) {
            results += res.get(i);
            results += "#";
        }
        return results;
    }
    //前序遍历一下
    private void Preorder(TreeNode root, List<String> res){
        if(root == null) return;
        res.add(String.valueOf(root.val));
        Preorder(root.left,res);
        Preorder(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")) return null;
        String[] values = data.split("#");
        int[] value = new int[values.length];
        for(int i = 0; i < value.length; i++)
            value[i] = Integer.valueOf(values[i]);
        TreeNode root = Construct(value,0,value.length-1);
        return root;
    }
    //重新构造
    private TreeNode Construct(int[] data,int start,int end){
        if(end < start || end >= data.length) return null;
        TreeNode root = new TreeNode(data[start]);
        //找到比root值大的位置
        int i;
        for(i = start+1; i <= end; i++)
            if(data[i] > data[start]) break;
        root.left = Construct(data,start+1,i-1);
        root.right = Construct(data,i,end);
        return root;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        String str = method.serialize(node2);
        TreeNode res = method.deserialize(str);
    }
}
