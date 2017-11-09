package question93;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by duncan on 17-11-9.
 */

//ip地址(没考虑0的情况)
public class Solution {
    public void IP(String s,int k,List<String> res,List<String> cur){
        if(k == 0) {
            if(s.length() == 0) {
                String result = "";
                for(int i = cur.size()-1; i >= 0; i--) {
                    result += cur.get(i);
                    if(i != 0)
                        result += ".";
                }
                res.add(result);
            }
            return;
        }else
        {
            if(s.length() - 1 >= 0) {
                String toadd = String.valueOf(s.charAt(s.length() - 1));
                cur.add(toadd);
                IP(s.substring(0, s.length() - 1), k - 1, res, cur);
                cur.remove(cur.size() - 1);
            }
            if(s.length() - 2 >= 0) {
                String toadd = s.substring(s.length() - 2, s.length());
                if(toadd.charAt(0) != '0') {
                    cur.add(toadd);
                    IP(s.length() - 2 > 0 ? s.substring(0, s.length() - 2) : "", k - 1, res, cur);
                    cur.remove(cur.size() - 1);
                }
            }
            if(s.length() - 3 >= 0) {
                String temp = s.substring(s.length() - 3, s.length());
                if (Integer.valueOf(temp) <= 255 && temp.charAt(0) != '0') {
                    cur.add(s.substring(s.length() - 3, s.length()));
                    IP(s.length() - 3 > 0 ? s.substring(0, s.length() - 3) : "", k - 1, res, cur);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> cur = new Stack<>();
        IP(s,4,res,cur);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String s = "010010";
        System.out.println(method.restoreIpAddresses(s));
    }
}
