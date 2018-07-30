package question763;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        //记录每个字符的其实位置和结束位置
        int[][] pos = new int[26][2];
        for(int i = 0; i < 26; i++){
            //对于每一个字符寻找起始和结束位置
            char target = (char)('a'+i);
            pos[i][0] = S.indexOf(target);
            pos[i][1] = S.lastIndexOf(target);
        }
        //遍历字符串
        char[] strs = S.toCharArray();
        int i = 0,end = i;
        List<Integer> res = new ArrayList<>();
        while (i < strs.length){
            end = pos[strs[i]-'a'][1];
            for(int j = i; j < end; j++){
                if(pos[strs[j]-'a'][1] > end) end = pos[strs[j]-'a'][1];
            }
            res.add(end - i + 1);
            i = end + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String S = "aba";
        List<Integer> res = method.partitionLabels(S);
        for(int i : res)
            System.out.print(i + " ");
    }
}
