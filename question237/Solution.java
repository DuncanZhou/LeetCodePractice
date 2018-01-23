package question237;

/**
 * Created by duncan on 18-1-23.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution {
    public void deleteNode(ListNode node) {
        //删除一个结点,只给要删除结点
            node.val = node.next.val;
            node.next = node.next.next;
    }
}
