package question290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by duncan on 18-1-28.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;
        Map<Character,String> map = new HashMap<>();
        Set<String> has = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++)
        {
            if(map.containsKey(pattern.charAt(i))) {
                if(!map.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            }else {
                if(has.contains(words[i]))
                    return false;
                map.put(pattern.charAt(i), words[i]);
                has.add(words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(method.wordPattern(pattern,str));
    }
}
