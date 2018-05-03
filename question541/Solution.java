package question541;

/**
 * Created by duncan on 18-5-3.
 */
public class Solution {
    public String reverseStr(String s, int k) {
        if(s.length() < k){
            StringBuilder temp = new StringBuilder(s);
            return temp.reverse().toString();
        }
        if(s.length() <= 2 * k){
            StringBuilder temp = new StringBuilder(s.substring(0,k));
            return temp.reverse().toString() + s.substring(k,s.length());
        }
        StringBuilder temp = new StringBuilder(s.substring(0,2*k));
        String left = s.substring(2*k,s.length());
        return reverseStr(temp.toString(),k) + reverseStr(left,k);
    }
}
