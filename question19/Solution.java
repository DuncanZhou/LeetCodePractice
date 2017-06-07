package question19;
//definition for singly-linked list
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}
public class Solution {

	public ListNode removeNthFromEnd(ListNode head, int n){
		ListNode p = head;
		ListNode q = head;
		int count = 0;
		while(q.next != null){
			if(count >= n)
				p = p.next;
			q = q.next;
			count++;
		}
		if(count >= n)
			p.next = p.next.next;
		else{
			if(count == 0)
				head = null;
			else
				head = head.next;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
