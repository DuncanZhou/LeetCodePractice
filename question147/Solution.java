package question147;

/**
 * Created by duncan on 18-1-3.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode cur = head.next, end = head;
        while (cur != null){
            //从head到end找插入的位置
            ListNode pre = head,p = head;
            while(p != cur){
                if(cur.val > p.val) {
                    pre = p;
                    p = p.next;
                }
                else
                    break;
            }
            //最大的一个
            if(p == cur){
                end = cur;
                cur = end.next;
            }
            //更新head
            else if(p == head){
                //更换head结点
                end.next = end.next.next;
                cur.next = head;
                head = cur;
                cur = end.next;
            }//插入到中间
            else{
                end.next = end.next.next;
                pre.next = cur;
                cur.next = p;
                cur = end.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(7);
//        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
        ListNode head = method.insertionSortList(node1);
        ListNode p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
