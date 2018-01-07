package question140;

import java.util.*;

/**
 * Created by duncan on 18-1-7.
 */
public class Solution {
    //给定一个字符串,和一个字符串字典,插入空格使得成为句子,返回所有可能的句子
//    public void wordBreak(String s, List<String> wordDict,List<String> res,List<String> cur) {
//        if(s.length() == 0)
//            return;
//        if(wordDict.contains(s)){
//            List<String> newcur = new ArrayList<>(cur);
//            newcur.add(s);
//            StringBuilder temp = new StringBuilder();
//            for(int i = 0; i < newcur.size(); i++){
//                temp.append(newcur.get(i));
//                if(i < newcur.size() - 1)
//                    temp.append(" ");
//            }
//            res.add(temp.toString());
//        }
//        for(int i = 0; i < s.length(); i++){
//            if(wordDict.contains(s.substring(0,i))){
//                cur.add(s.substring(0,i));
//                wordBreak(s.substring(i),wordDict,res,cur);
//                cur.remove(cur.size()-1);
//            }
//        }
//    }
//    public List<String> wordBreak(String s, List<String> wordDict) {
////        List<String> res = new ArrayList<>();
////        List<String> cur = new ArrayList<>();
////        wordBreak(s,wordDict,res,cur);
////        return res;
//
//    }


    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "catsanddog";
        //dict = ["cat", "cats", "and", "sand", "dog"]
        Set<String> wordDict = new HashSet<String>(){{add("cat");add("cats");add("and");add("sand");add("dog");}};
        System.out.println(method.wordBreak(str,wordDict));
    }
}
