package question792;

/**
 * Created by duncan on 18-5-8.
 */
public class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        for(int i = 0; i < words.length; i++)
            if(check(S,words[i])) res++;
        return res;
    }
    public boolean check(String s,String p){
        //判断p字符串是否是s的子串
        int index1 = 0, index2 = 0;
        while(index1 < s.length() && index2 < p.length()){
            if(s.charAt(index1) == p.charAt(index2)){
                index1++;
                index2++;
            }else index1++;
        }
        if(index2 == p.length()) return true;
        else return false;
    }
}
