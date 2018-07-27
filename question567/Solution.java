package question567;

import java.util.*;

public class Solution {
    //滑动窗口来做
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        HashMap<Character,Integer> original = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) original.put(s1.charAt(i),original.getOrDefault(s1.charAt(i),0)+1);
        int owe = s1.length();
        HashMap<Character,Integer> cur = new HashMap<>();
        //初始化滑动窗口
        char[] strs = s2.toCharArray();
        for(int i = 0; i < s1.length(); i++){
            if(original.containsKey(strs[i])){
                cur.put(strs[i],cur.getOrDefault(strs[i],0)+1);
                if(cur.get(strs[i]) <= original.get(strs[i])) owe --;
            }
        }
        if(owe == 0) return true;
        //开始滑动
        for(int i = s1.length(); i < strs.length; i++){
            //移除i-s1.length位置的，并更新cur和owe
            if(original.containsKey(strs[i-s1.length()])){
                cur.put(strs[i-s1.length()],cur.get(strs[i-s1.length()])-1);
                if(cur.getOrDefault(strs[i-s1.length()],0) < original.get(strs[i-s1.length()]))
                    owe++;
            }
            //更新
            if(original.containsKey(strs[i])){
                cur.put(strs[i],cur.getOrDefault(strs[i],0)+1);
                if(cur.get(strs[i]) <= original.get(strs[i])) owe --;
            }
            if(owe == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String s1 = "adc";
        String s2 = "dadc";
        System.out.println(method.checkInclusion(s1,s2));
    }
}
