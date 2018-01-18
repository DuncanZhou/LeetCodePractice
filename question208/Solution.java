package question208;

/**
 * Created by duncan on 18-1-18.
 */

//实现前缀树的方法
class Trie {

    //TrieNode
    class TrieNode{
        char val;
        TrieNode[] next = new TrieNode[26];
        TrieNode(char c){
            val = c;
        }
        //标记是否式word末尾处
        boolean flag = false;
    }
    TrieNode root = new TrieNode('*');
    /** Initialize your data structure here. */
    public Trie() {

    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            if(p.next[index] == null)
                p.next[index] = new TrieNode(word.charAt(i));
            p = p.next[index];
        }
        //单词结尾
        p.flag = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(p.next[index] == null)
                return false;
            p = p.next[index];
        }
        if(p.flag)
            return true;
        else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(p.next[index] == null)
                return false;
            p = p.next[index];
        }
        return true;
    }
}
public class Solution {
    public static void main(String[] args) {
        Solution method = new Solution();
        Trie trie = new Trie();
        trie.insert("search");
        System.out.println(trie.search("searc"));
        System.out.println(trie.startsWith("seard"));
    }
}
