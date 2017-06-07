package question30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DuncanZhou on 2016/8/26.
 * 利用全排列算法
 */
public class Solution {
//    private List<String> list = new ArrayList<String>();
//    public  void swap(String[] str,int a,int b){
//        String temp = str[a];
//        str[a] = str[b];
//        str[b] = temp;
//    }
//    public  void pernum(String[] str,int start,int end){
//        if(start == end - 1){
//            String ret = "";
//            for(int i = 0;i < end; i++)
//                ret += str[i];
//            list.add(ret);
//        }else{
//            for(int i = start; i < end; i++){
//                swap(str,start,i);
//                pernum(str,start + 1,end);
//                swap(str,start,i);
//            }
//        }
//    }
//    public  List<Integer> findSubstring(String s,String[] words){
//        List<Integer> ret = new ArrayList<Integer>();
//        pernum(words,0,words.length);
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            String word = (String)iterator.next();
//            String substr = s.substring(0);
//            int set = 0;
//            int len = words[0].length();
//            while(substr.length() >= len) {
//                int index = substr.indexOf(word);
//                if (index != -1){
//                    if(!ret.contains(index + set))
//                        ret.add(index + set);
//                    set ++;
//                    substr = s.substring(set);
//                }else
//                    break;
//            }
//        }
//        return ret;
//    }
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ret = new ArrayList<Integer>();
    int slen = s.length(), llen = words.length;
    if (slen <= 0 || llen <= 0)
        return ret;
    int wlen = words[0].length();

    // get the words' map
    HashMap<String, Integer> map = new HashMap<>();
    for (String str : words) {
        if (map.containsKey(str)) {
            map.put(str, map.get(str) + 1);
        } else {
            map.put(str, 1);
        }
    }

    for (int i = 0; i < wlen; ++i) {
        //left是索引
        int left = i, count = 0;
        HashMap<String, Integer> tmap = new HashMap<>();

        for (int j = i; j <= slen - wlen; j += wlen) {
            String str = s.substring(j, j + wlen);

            if (map.containsKey(str)) {
                if (tmap.containsKey(str)) {
                    tmap.put(str, tmap.get(str) + 1);
                } else {
                    tmap.put(str, 1);
                }

                if (tmap.get(str) <= map.get(str)) {
                    count++;
                } else {
                    // too many words, push the 'left' forward
                    while (tmap.get(str) > map.get(str)) {
                        String tmps = s.substring(left, left + wlen);
                        tmap.put(tmps, tmap.get(tmps) - 1);
                        if (tmap.get(tmps) < map.get(tmps)) {
                            // if affect the count
                            count--;
                        }
                        left += wlen;
                    }
                }

                // get the answer
                if (count == llen) {
                    ret.add(left);
                    // it's better to push forward once
                    String tmps = s.substring(left, left + wlen);
                    tmap.put(tmps, tmap.get(tmps) - 1);
                    count--;
                    left += wlen;
                }
            } else {
                // not any match word
                tmap.clear();
                count = 0;
                left = j + wlen;
            }
        }
    }
    return ret;
    }
    public static void main(String[] args){
        Solution sl = new Solution();
        String[] str = {"bar","foo","the"};
        String s = "barfoofoobarthefoobarman";
        List<Integer> result = new ArrayList<Integer>();
        result = sl.findSubstring(s,str);
        System.out.println(result);
    }
}
