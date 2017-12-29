package question142;

/**
 * Created by duncan on 17-12-29.
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
    //判断有没有环,有环返回起始点,无环返回null
    public ListNode detectCycle(ListNode head) {
        //定义两个快慢指针
        ListNode p = head,q = head;
        if(head == null)
            return null;
        if(p.next == p)
            return head;
        while (p != null){
            if(q != null && q.next != null)
                q = q.next.next;
            else
                break;
            p = p.next;
            if(p == q)
                break;
        }
        if(p == null || q == null || q.next == null)
            return null;
        else{
            if(p == head)
                return head;
            //从head往后找
            ListNode h = head.next;
            while(h != p){
                q = p.next;
                while(q != p){
                    if(q == h)
                        break;
                    q = q.next;
                }
                if(q == h)
                    break;
                h = h.next;
            }
            return h;
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node3;
        System.out.println(method.detectCycle(node1));
    }
}
