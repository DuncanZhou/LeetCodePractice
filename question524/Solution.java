package question524;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by duncan on 18-4-20.
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        //先将d中按照长度和字典顺序排序
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String o1,String o2){
                if(o1.length() == o2.length()) return o1.compareTo(o2);
                else return o2.length() - o1.length();
            }
        });
        for(String str : d)
            queue.add(str);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            int index = 0;
            for(int i = 0; i < s.length(); i++){
                if(index == cur.length()) return cur;
                if(s.charAt(i) == cur.charAt(index))
                    index++;
            }
            if(index == cur.length()) return cur;
        }
        return "";
    }
}
