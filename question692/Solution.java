package question692;

import java.util.*;

public class Solution {
    //返回出现次数前k个的字符串，频数相同返回字典顺序在前的
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String,Integer> map = new TreeMap<>();
        for(String word : words)
            map.put(word,map.getOrDefault(word,0)+1);
        List<Map.Entry<String,Integer>> wordsList = new ArrayList<>(map.entrySet());
        Collections.sort(wordsList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                else return o2.getValue() - o1.getValue();
            }
        });
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: wordsList){
            if(res.size() == k) break;
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> res = method.topKFrequent(words,4);
        for(String r : res)
            System.out.println(r);
    }
}
