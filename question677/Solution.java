package question677;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-4-20.
 */

//实现前缀树
class TreeNode{
    char c;
    boolean flag = false;
    int val;
    ArrayList<TreeNode> children;
    TreeNode(char a){
        c = a;
        children = new ArrayList<>();
    }
}
class MapSum {

    TreeNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TreeNode('#');
    }

    public void insert(String key, int val) {
        //将key插入root,如果已有则更新权值
        TreeNode p = root;
        for(char c : key.toCharArray()){
            ArrayList<TreeNode> child = p.children;
            boolean flag = false;
            int i;
            for(i = 0; i < child.size(); i++)
                if(child.get(i).c == c){flag =true; break;}
            if(!flag){
                p.children.add(new TreeNode(c));
                p = child.get(child.size() -1);
            }else
                p = child.get(i);
        }
        p.val = val;
        //单词结尾
        p.flag = true;
    }

    public int sum(String prefix) {
        //对具有相同prefix的单词的val相加
        TreeNode p = root;
        for(char c : prefix.toCharArray()){
            //先找到前缀尾
            ArrayList<TreeNode> child = p.children;
            int i;
            for(i = 0; i < child.size(); i++)
                if(child.get(i).c == c) break;
            //没找到前缀
            if(i == child.size()) return 0;
            p = child.get(i);
        }
        return helper(p);
    }
    //将root开始的所有结尾值相加
    private int helper(TreeNode root){
        if(root == null) return 0;
        int sum = 0;
        if(root.flag) sum += root.val;
        List<TreeNode> child = root.children;
        for(TreeNode p : child)
            sum += helper(p);
        return sum;
    }
}
public class Solution {
    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("a",3);
        System.out.println(obj.sum("ap"));
//        obj.insert("app",2);
//        System.out.println(obj.sum("ap"));
    }
}
