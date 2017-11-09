package question92;

import java.util.Stack;

/**
 * Created by duncan on 17-11-9.
 */



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
//倒序指定区间的节点
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //用栈来实现倒序
        Stack<Integer> stack = new Stack<>();
        ListNode fakenode = new ListNode(-1);
        fakenode.next = head;
        ListNode p = fakenode,cur = fakenode;
        int index = 0;
        while(p != null)
        {
            if(index > n)
                break;
            if(index >= m && index <= n)
                stack.push(p.val);
            if(index == m - 1)
                cur = p;
            index++;
            p = p.next;
        }
        cur.next = p;
        //出栈
        while(!stack.isEmpty()){
            ListNode temp = new ListNode(stack.pop());
            temp.next = cur.next;
            cur.next = temp;
            cur = temp;
        }
        return fakenode.next;
    }
}
