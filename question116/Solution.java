package question116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by duncan on 17-11-28.
 */

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}
public class Solution {
     public void connect(TreeLinkNode root) {

//         if (root == NULL) return;
//         TreeLinkNode *pre = root;
//         TreeLinkNode *cur = NULL;
//         while(pre->left) {
//             cur = pre;
//             while(cur) {
//                 cur->left->next = cur->right;
//                 if(cur->next) cur->right->next = cur->next->left;
//                 cur = cur->next;
//             }
//             pre = pre->left;




         if(root == null)
              return;
         Queue<TreeLinkNode> queue = new LinkedList<>();
         int level = 1;
         TreeLinkNode right = null;
         int count = 0;
         queue.add(root);
         while(!queue.isEmpty()){
             TreeLinkNode temp = queue.poll();
             count++;
             temp.next = right;
             right = temp;
             if(count == (int)Math.pow(2,level-1)) {
                 right = null;
                 count = 0;
                 level++;
             }
             if(temp.right != null)
                queue.add(temp.right);
             if(temp.left != null)
                queue.add(temp.left);
         }
     }

    public static void main(String[] args) {
        Solution method = new Solution();
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        method.connect(node1);
    }
}
