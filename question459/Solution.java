package question459;

/**
 * Created by duncan on 18-3-20.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i <= s.length() / 2; i++)
            if(helper(s.substring(i),s.substring(0,i))) return true;
        return false;
    }
    //超时
//    private boolean helper(String s, String p){
//        if(s.equals("")) return true;
//        if(s.length() < p.length()) return false;
//        for(int i = 0; i < p.length(); i++)
//            if(s.charAt(i) != p.charAt(i)) return false;
//        return helper(s.substring(p.length()),p);
//    }
    private boolean helper(String s,String p){
        if(s.length() % p.length() != 0) return false;
        int len = p.length();
        for(int i = 0; i < len; i++){
            int temp = i;
            while(temp < s.length() && s.charAt(temp) == p.charAt(i))
                temp += len;
            if(temp < s.length()) return false;
        }
        return true;
    }
}
