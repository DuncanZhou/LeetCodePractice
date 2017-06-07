package question23;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}

public class Solution {
//	static int min,flag;
	public static class ListNodeComparator implements Comparator<ListNode>{
		public int compare(ListNode l1,ListNode l2){
			return l1.val - l2.val;
		}
	}
	public static ListNode mergeKLists(ListNode[] lists){
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new ListNodeComparator());
		for(int i = 0 ; i < lists.length; i++)
		{
			if(lists[i] != null)
				heap.offer(lists[i]);
		}
		ListNode root = null;
		ListNode tail = root;
		while(!heap.isEmpty()){
			ListNode temp = heap.poll();
			if(root == null){
				root = temp;
				tail = root;
			}else{
				tail.next = temp;
				tail = temp;
			}
			if(temp.next != null){
				heap.offer(temp.next);
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
