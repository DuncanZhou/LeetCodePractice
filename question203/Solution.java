package question203;

/**
 * Created by duncan on 18-1-16.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution {
    //基础题,移除链表中某个元素
    public ListNode removeElements(ListNode head, int val) {
        //加一个假的头结点
        ListNode fakenode = new ListNode(0);
        fakenode.next = head;
        ListNode p = fakenode.next,pre = fakenode;
        while(p != null){
            if(p.val == val){
                pre.next = p.next;
                p = pre.next;
            }else
            {
                pre = p;
                p = p.next;
            }
        }
        return fakenode.next;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode res = method.removeElements(node1,3);
        ListNode p = res;
        while(p != null)
        {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
