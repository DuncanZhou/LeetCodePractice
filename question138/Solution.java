package question138;

/**
 * Created by duncan on 17-12-28.
 */


class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};
public class Solution {
    //复制一份这样的链表
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode resHead = new RandomListNode(head.label);
        RandomListNode cur = resHead;
        RandomListNode pre = head;
        RandomListNode p = head.next;
        while (p != null){
            RandomListNode next = new RandomListNode(p.label);
            cur.next = next;
            if(pre.random == p)
               cur.random = next;
            else {
                //从p结点往前去找,next是不是某个结点的random,qt同步去找
                RandomListNode q = head;
                RandomListNode qt = resHead;
                while (q != null && q != p) {
                    if (q.random == p)
                        break;
                    q = q.next;
                    qt = qt.next;
                }
                if(q != null && q != p)
                    qt.random = next;
            }
            //在前面找next的random
            if(p.random == pre)
                next.random = cur;
            else{
                //从p结点往前去找,next是不是某个结点的random,qt同步去找
                RandomListNode q = head;
                RandomListNode qt = resHead;
                while (q != null && q != p) {
                    if (p.random == q)
                        break;
                    q = q.next;
                    qt = qt.next;
                }
                if(q != null && q != p)
                    next.random = qt;
            }
            pre = p;
            p = p.next;
            //尾插法
            cur = cur.next;
        }
        return resHead;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
//        RandomListNode node3 = new RandomListNode(3);
//        RandomListNode node4 = new RandomListNode(4);
        node1.next = node1;
        node1.random = node1;
//        node2.next = null;
//        node3.next = node4;
//        node1.random = node3;
//        node2.random = node4;
//        node3.random = node1;
        method.copyRandomList(node1);
    }
}
