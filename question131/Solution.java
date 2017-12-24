package question131;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-12-24.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        DFS(s,cur,res);
        return res;
    }
    public void DFS(String s,List<String> cur,List<List<String>> res){
        if(s.length() == 0)
        {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 1; i <= s.length(); i++){
            String str = s.substring(0,i);
            if(isPalindrom(str)){
                cur.add(str);
                DFS(s.substring(i),cur,res);
                cur.remove(cur.size()-1);
            }
            else
                continue;
        }
    }
    public boolean isPalindrom(String s){
        //判断s是否是回文
        int start = 0, end = s.length()-1;
        boolean flag = true;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "aab";
        System.out.println(method.partition(str));
    }
}
