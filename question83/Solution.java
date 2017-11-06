package question83;

/**
 * Created by duncan on 17-11-6.
 */

//删除重复的元素,保留重复元素中的一个
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head,cur = head.next;
        ListNode link = head;
        while(cur != null){
            while(cur != null && cur.val == pre.val)
                cur = cur.next;
            link.next = cur;
            if(cur == null)
                break;
            link = cur;
            pre = cur;
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution method = new Solution();
        ListNode res = method.deleteDuplicates(node1);
        ListNode p = res;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
