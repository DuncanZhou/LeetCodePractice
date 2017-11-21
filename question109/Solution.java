package question109;

/**
 * Created by duncan on 17-11-20.
 */


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode IntoBST(ListNode head,ListNode end){
        if(head == end)
            return null;
        ListNode start = head;
        ListNode mid = head;
        while(start != end && start.next != end){
            start = start.next.next;
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = IntoBST(head,mid);
        root.right = IntoBST(mid.next,end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
            return IntoBST(head,null);
    }
}