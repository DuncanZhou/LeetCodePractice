package question212;

import java.util.*;

/**
 * Created by duncan on 18-1-20.
 */
class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode(char c) {
        this.c = c;
    }

    public TrieNode(){};
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if(i==word.length()-1) t.leaf=true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        return t!=null && t.leaf;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!children.containsKey(c)) return null;
            t = children.get(c);
            children = t.children;
        }
        return t;
    }
}

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if(board==null || words==null || board.length==0 || words.length==0) return new ArrayList<String>(res);
        boolean[][] visited = new boolean[board.length][board[0].length];

        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                //因为只要求在同一个单词中同一个字符不能同时出现
                search(board, visited, trie, i, j, new StringBuilder(), res);
            }
        }
        return new ArrayList<String>(res);
    }

    private void search(char[][] board,boolean[][] visited,Trie trie,int i,int j, StringBuilder sb, Set<String> res) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || visited[i][j])  return;
        sb.append(board[i][j]);
        String s = sb.toString();
        visited[i][j] = true;
        if(trie.startsWith(s)) {
            if(trie.search(s)) res.add(s);
            //深搜
            search(board, visited, trie, i-1, j, sb, res);
            search(board, visited, trie, i+1, j, sb, res);
            search(board, visited, trie, i, j-1, sb, res);
            search(board, visited, trie, i, j+1, sb, res);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        char[][] board = {{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},{'a','b','a','b','b','a'},{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},{'a','a','b','a','a','b'}};
        String[] words = {"aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};
        System.out.println(method.findWords(board,words));
    }
}
