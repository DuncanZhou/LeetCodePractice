package question676;


import java.util.HashMap;
import java.util.HashSet;

class MagicDictionary {
    HashMap<String, HashSet<String>> map ;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str: dict) {
            for (int i = 0; i < str.length(); i++) {
                String tmp = str.substring(0, i) + "*" + str.substring(i+1, str.length());
                if (map.containsKey(tmp)) {
                    map.get(tmp).add(str);
                } else {
                    HashSet<String> set = new HashSet<>();
                    set.add(str);
                    map.put(tmp, set);
                }
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String str = word.substring(0, i) + "*" + word.substring(i+1, word.length());
            if (map.containsKey(str)) {
                HashSet<String> set = map.get(str);
                if ((set.size() == 1 && !set.contains(word)) || set.size() > 1) return true;
            }
        }
        return false;
    }
}
