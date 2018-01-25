package question126;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-12-6.
 */
public class Solution {
    public void findLadders(String beginWord, String endWord, List<String> wordList,List<List<String>> res,List<String> cur) {

    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<String>(){{add(beginWord);}};
        findLadders(beginWord,endWord,wordList,res,cur);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        List<String> wordlist = new ArrayList<String>(){{add("hot");add("dot");add("dog");add("lot");add("log");add("cog");}};
        System.out.println(method.findLadders("hit","cog",wordlist));
    }
}
