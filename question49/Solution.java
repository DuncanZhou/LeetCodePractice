package question49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duncan on 17-10-27.
 */
public class Solution {
    public String Convert(String string){
        int[] numer = new int[26];
        for(int i = 0; i < string.length(); i++){
            numer[string.charAt(i)-'a'] += 1;
        }
        StringBuilder tempstring = new StringBuilder();
        for(int i = 0; i < 26; i++)
            tempstring.append(numer[i]);
        return tempstring.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> values = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String id = Convert(strs[i]);
            if(values.containsKey(id)){
                values.get(id).add(strs[i]);
            }else
            {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                values.put(id,temp);
            }
        }
        //adjust values
        List<List<String>> results = new ArrayList<>();
        for(List<String> value:values.values())
            results.add(value);
        return results;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        String[] string  = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(method.groupAnagrams(string));
    }

}
