package question141;

/**
 * Created by duncan on 17-12-25.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
    }
}
public class Solution {
    //判断链表是否有环,不使用额外空间
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        if(head == null)
            return false;
        ListNode q = head.next;
        while(q != null && q != head){
            p.next = head;
            p = q;
            q = p.next;
        }
        return q == null ? false : true;
    }
}
