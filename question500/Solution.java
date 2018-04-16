package question500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by duncan on 18-4-16.
 */
public class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        //把每行映射一下
        List<Set<Character>> alphas = new ArrayList<>();
        char[] row1 = {'q','w','e','e','r','t','y','u','i','o','p'};
        char[] row2 = {'a','s','d','f','g','h','j','k','l'};
        char[] row3 = {'z','x','c','v','b','n','m'};
        HashSet<Character> rows1 = new HashSet<>();
        HashSet<Character> rows2 = new HashSet<>();
        HashSet<Character> rows3 = new HashSet<>();
        Convert(rows1,row1);
        Convert(rows2,row2);
        Convert(rows3,row3);
        alphas.add(rows1);
        alphas.add(rows2);
        alphas.add(rows3);
        for(String word: words){
            boolean flag = true;
            //全部转换成小写
            char[] arrays = word.toLowerCase().toCharArray();
            int pre = 0;
            for(int i = 0; i < alphas.size(); i++)
                if(alphas.get(i).contains(arrays[0])) {pre = i; break;}
            for(int i = 1; i < arrays.length; i++)
            {
                int j;
                for(j = 0; j < alphas.size(); j++)
                    if(alphas.get(j).contains(arrays[i])) break;
                if(j != pre){flag = false; break;}
            }
            if(flag) res.add(word);
        }
        String[] results = new String[res.size()];
        int index = 0;
        for(String word: res)
            results[index++] = word;
        return results;
    }
    private void Convert(HashSet<Character> set, char[] row){
        for(char c:row)
            set.add(c);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String[] words = {"Dad"};
        for(String word : method.findWords(words))
            System.out.println(word);
    }
}
