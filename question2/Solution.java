package question2;
/**
 * Definition for singly-linked list.
 * public class ListNode{
 * 		int val;
 *  	ListNode next;
 *  	ListNode(int x){ val = x;}
 * }
 * @author DuncanZhou
 *
 */

public class Solution {
	//定义的链表结构
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		
		int flag = 0;    //判断是否有进位
		int temp = l1.val + l2.val;
		if( temp >= 10){
			temp -= 10;
			flag = 1;
		}
		ListNode c = new ListNode(temp);
		ListNode pnode = null;
		ListNode tail = c;
		l1 = l1.next;
		l2 = l2.next;
		while(l1 != null && l2 != null){
			temp = l1.val + l2.val;
			if( temp + flag >= 10)   //需要进位
			{
				temp = temp+flag -10;
				flag = 1;
			}
			else{               //不需进位
				temp = temp + flag;
				flag = 0;
			}
			pnode = new ListNode(temp);
			tail.next = pnode;
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1 != null ){
			pnode = new ListNode(flag);
			tail.next = addTwoNumbers(pnode,l1);
		}
		if(l2 != null){
			pnode = new ListNode(flag);
			tail.next = addTwoNumbers(pnode,l2);
		}
			if(l1 == null && l2 == null && flag == 1){
				pnode = new ListNode(1);
				tail.next = pnode;
			}
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode C = addTwoNumbers(l1,l2);
		while(C != null){
			System.out.print(C.val+" ");
			C = C.next;
		}
	}
}
/**  官方解法
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}**/