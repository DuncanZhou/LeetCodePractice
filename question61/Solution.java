package question61;

/**
 * Created by duncan on 17-10-31.
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //首尾相连,在n-k处掐断
        ListNode p = head;
        if(p == null)
            return null;
        int n = 1;
        while(p.next != null){
            p = p.next;
            n++;
        }
        p.next = head;
        for(int i = 0; i < Math.abs((n - k % n)); i++){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
