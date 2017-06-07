package question21;
//单链表的定义
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}
public class Solution {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode head,l3,p = l1,q = l2;
		if(p == null)
		{
			head = q;
			return head;
		}
		if(q == null){
			head = p;
			return head;
		}
		if(p.val < q.val)
		{
			head = p;
			p = p.next;
		}
		else{
			head = q;
			q = q.next;
		}
		l3 = head;
		while(p != null && q != null){
			ListNode temp = null;
			if(p.val < q.val){
				temp = new ListNode(p.val);
				l3.next = temp;
				l3 = temp;
				p = p.next;
			}else{
				temp = new ListNode(q.val);
				l3.next = temp;
				l3 = temp;
				q = q.next;
			}
		}
		if(p != null){
			l3.next = p;
		}else if(q != null)
			l3.next = q;
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
