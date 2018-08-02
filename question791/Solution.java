package question791;

import java.util.Arrays;

public class Solution {
    public String customSortString(String S, String T) {
        char[] strs = T.toCharArray();
        char[] res = new char[strs.length];
        boolean[] index = new boolean[strs.length];
        int j = 0;
        for(int i = 0; i < S.length(); i++){
            for(int k = 0; k < strs.length; k++){
                if(strs[k] == S.charAt(i)){
                    res[j++] = strs[k];
                    index[k] = true;
                }
            }
        }
        for(int i = 0; i < strs.length; i++){
            if(!index[i]) res[j++] = strs[i];
        }
        return String.valueOf(res);
    }
}
