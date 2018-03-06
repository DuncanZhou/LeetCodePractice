package question336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duncan on 18-3-6.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        //用一个map存储翻转后的字符串,然后在原来的数组中找有没有相同的
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String str = new StringBuilder(words[i]).reverse().toString();
            map.put(str,i);
        }
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            int index = i;
            //切分字符串为ls和rs,在map中寻找ls或者rs然后拼接
            for(int j = 0; j < str.length(); j++){
                int len = str.length();
                String ls = str.substring(0,j);
                String rs = str.substring(j,len);
                if(check(rs) && map.containsKey(ls) && map.get(ls) != i) {
                    res.add(new ArrayList<Integer>() {{
                        add(index);
                        add(map.get(ls));
                    }});
                    //为空要单独判断
                    if(ls.equals(""))
                        res.add(new ArrayList<Integer>() {{
                            add(map.get(ls));
                            add(index);
                        }});
                }
                if(check(ls) && map.containsKey(rs) && map.get(rs) != i)
                    res.add(new ArrayList<Integer>(){{add(map.get(rs));add(index);}});
            }
        }
        return res;
    }
    private boolean check(String str){
        int start = 0, end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) == str.charAt(end))
            {
                start++;
                end--;
            }else break;
        }
        if(start >= end)
            return true;
        else return false;
    }
    public static void main(String[] args) {
        Solution method =new Solution();
        String[] words = {"abcd", "dcba", "lls", "s", "sssll",""};
        List<List<Integer>> res = method.palindromePairs(words);
        for(List<Integer> r: res){
            for(int x : r){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
