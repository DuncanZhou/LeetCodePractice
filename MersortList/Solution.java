package MersortList;

/**
 * Created by duncan on 18-4-20.
 */
class Node{
    int val;
    Node next;
    Node(int a){
        val = a;
    }
}
//对链表使用归并排序
public class Solution {
    private Node MergeSort(Node root){
        if(root == null || root.next == null) return root;
        //快慢指针找到中间位置
        Node slow = root, fast = root;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //截断
        Node mid = slow.next;
        slow.next = null;
        Node A = MergeSort(root);
        Node B = MergeSort(mid);
        root = Merge(A,B);
        return root;
    }
    //合并a,b链表
    private Node Merge(Node a,Node b){
        Node fakeNode = new Node(0);
        Node p = fakeNode;
        while(a != null && b != null){
            if(a.val < b.val){
                p.next = new Node(a.val);
                a = a.next;
            }else{
                p.next = new Node(b.val);
                b = b.next;
            }
            p = p.next;
        }
        //加入未判断完的
        Node c = a != null ? a : b;
        while(c != null){
            p.next = new Node(c.val);
            p = p.next;
            c = c.next;
        }
        return fakeNode.next;
    }
    public static void main(String[] args) {
        Node node1 = new Node(6);
        Node node2 = new Node(4);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Solution method = new Solution();
        Node res = method.MergeSort(node1);
        //遍历res
        Node p = res;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
