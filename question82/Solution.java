package question82;

/**
 * Created by duncan on 17-11-6.
 */


//删除重复的元素,一旦有元素有重复即删除所有该元素(链表排好序)
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode fakeNode =new ListNode(-1) ;

        ListNode result=fakeNode;
        ListNode pre=head;
        ListNode cur=head;
        while(cur != null && cur.next != null)
        {
            while(cur.next != null && cur.next.val == pre.val)
                cur = cur.next;
            //没有重复的
            if(cur == pre)
            {
                result.next = pre;
                result = result.next;
            }
            pre = cur.next;
            cur = cur.next;
        }
        result.next = cur;
        return fakeNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
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
