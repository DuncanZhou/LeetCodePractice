package question206;

/**
 * Created by duncan on 18-1-17.
 */


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseList(ListNode head) {

//递归
//        if(head==null || head.next==null)
//            return head;
//        ListNode nextNode=head.next;
//        ListNode newHead=reverseList(nextNode);
//        nextNode.next=head;
//        head.next=null;
//        return newHead;


        if(head == null || head.next == null)
            return head;
        ListNode fakenode = new ListNode(0);
        fakenode.next = head;
        ListNode pre = fakenode,p = head,pp = p.next;
        while(p != null){
            if(pre != fakenode)
                p.next = pre;
            else
                p.next = null;
            pre = p;
            p = pp;
            if(p != null)
                pp = p.next;
        }
        fakenode.next = pre;
        return fakenode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        Solution method = new Solution();
        ListNode p = method.reverseList(node1);

        while(p != null)
        {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
