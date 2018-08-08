package question662;


import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    class Node{
        TreeNode node;
        int pos;
        Node(TreeNode a,int b){
            node = a;
            pos = b;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;//层次遍历
        Queue<Node> queue = new LinkedList<>();
        StringBuilder cur = new StringBuilder();
        queue.offer(new Node(root,1));
        int res = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0, end = 0;
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                TreeNode node = temp.node;
                int pos = temp.pos;
                if(i == 0) start = pos;
                if(i == size -1 ) end = pos;
                if(node.left != null)
                    queue.offer(new Node(node.left,2*pos));
                if(node.right != null)
                    queue.offer(new Node(node.right,2*pos+1));
            }
            if(end - start + 1 > res) res = end - start + 1;
        }
        return res;
    }
}
