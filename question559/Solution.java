package question559;


import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Solution {
    // n叉树返回最大深度
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int childD = 0;
        for(Node child : root.children) {
            int temp = maxDepth(child);
            if (temp > childD) childD = temp;
        }
        return 1 + childD;
    }
}
