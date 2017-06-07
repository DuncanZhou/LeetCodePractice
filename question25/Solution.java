package question25;
//定义

import java.util.Stack;

public class Solution {
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	public static ListNode reverseKGroup(ListNode head,int k){
		//这里是存的结点，另一种用栈存储结点里的值也可以
		//Stack<Integer> stack = new Stack<Integer>();
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode p = head;
		ListNode tail = null;
		while(p != null)
		{
			//进栈
			for(int i = 0; i < k; i++)
			{
				ListNode temp = p;
				if(temp != null)
					stack.push(temp);
				else
					//将栈中结点出栈
					return head;
				p = p.next;
			}
			ListNode cur = p;
			//开始出栈
			while(!stack.isEmpty()){
				ListNode temp = stack.pop();
				if(tail == null){
					tail = temp;
					head = tail;
					tail.next = cur;
				}
				else{
					temp.next = cur;
					tail.next = temp;
					tail = temp;
				}
			}
			p = cur;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode q = head.next.next.next;
		q.next = new ListNode(5);
//		q.next.next = new ListNode(6);
		ListNode p = reverseKGroup(head,3);
		while(p != null){
			System.out.print(p.val+"->");
			p = p.next;
		}
	}

}
