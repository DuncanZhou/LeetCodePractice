package question328;

/**
 * Created by duncan on 18-2-28.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode even = head.next, p = head, q = even;
        while(p.next !=  null && q.next != null){
            p.next = p.next.next;
            p = p.next;
            q.next = q.next.next;
            q = q.next;
        }
        p.next = even;
        return head;
    }
}
