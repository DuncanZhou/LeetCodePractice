package question211;

/**
 * Created by duncan on 18-1-19.
 */


class WordDictionary {
    //构造前缀树
    class TrieNode{
        char val;
        boolean isword;
        TrieNode[] children = new TrieNode[26];
        TrieNode(char c){
            val = c;
        }
    }
    TrieNode root = new TrieNode('*');
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null)
            return;
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.children[index] == null)
                p.children[index] = new TrieNode(word.charAt(i));
            p = p.children[index];
        }
        p.isword = true;
    }
    public boolean search(String word,TrieNode root) {
        if(root == null)
            return false;
        if(word.length() == 0) {
            if(root.isword == true)
                return true;
            else
                return false;
        }
        if(word.charAt(0) == '.'){
            boolean res = false;
            for(int i = 0; i < 26; i++)
                res |= search(word.substring(1),root.children[i]);
            return res;
        }else {
            int index = word.charAt(0) - 'a';
            if (root.children[index] == null)
                return false;
            else
                return search(word.substring(1),root.children[index]);
        }
    }
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode p = root;
        return search(word,p);
    }
}

public class Solution {
    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        dic.addWord("search");
        System.out.println(dic.search("pad"));
        System.out.println(dic.search("bad"));
        System.out.println(dic.search(".ad"));
        System.out.println(dic.search("b.c"));
        System.out.println(dic.search("s."));
    }
}
