package question86;

/**
 * Created by duncan on 17-11-7.
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode fakehead = new ListNode(-1);
        fakehead.next = head;
        ListNode p = head,pre = fakehead,cur = pre;
        while(p != null){
            if(p.val < x){
                pre.next = p.next;
                p.next = cur.next;
                cur.next = p;
                cur = p;
                p = cur.next;
                pre = cur;
            }else
            {
                pre = p;
                p = p.next;
            }
        }
        return fakehead.next;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode p = method.partition(node1,2);
        while(p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}