package question242;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by duncan on 18-1-23.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> res = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
            if(res.containsKey(s.charAt(i)))
                res.put(s.charAt(i),res.get(s.charAt(i))+1);
            else
                res.put(s.charAt(i),1);
        for(int i = 0; i < t.length(); i++) {
            if (!res.containsKey(t.charAt(i)) || res.get(t.charAt(i)) == 0)
                return false;
            res.put(t.charAt(i),res.get(t.charAt(i))-1);
        }
        return true;
    }
}
