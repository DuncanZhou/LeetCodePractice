package question24;

public class Solution {

	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public static ListNode swapPairs(ListNode head){
		ListNode p = head;
		if(p == null || p.next == null)
			return head;
		else{
			ListNode q = p.next;
			while(q != null){
				ListNode r = q.next;
				q.next = p;
				if(p == head)
					head = q;
				p.next = r;
				if(r == null || r.next == null)
					return head;
				p.next = r.next;
				p = r;
				q = p.next;

			}
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
