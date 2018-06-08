package question696;

import java.util.Arrays;

public class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int[] group = new int[chars.length];
        int index = 0;
        group[0] = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i] == chars[i - 1])
                group[index]++;
            else
                group[++index] = 1;
        }
        int i = 0, count = 0;
        while(i < group.length - 1 && group[i] != 0){
            count += Math.min(group[i], group[i + 1]);
            i++;
        }
        return count;
    }
//    public int countBinarySubstrings(String s) {
//        ArrayList<String> res = new ArrayList<>();
//        //设置滑动窗口
//        for(int window = 1; window < s.length(); window += 2) {
//            for (int start = 0; start + window < s.length(); start++) {
//                int end = start + window;
//                String substring = s.substring(start,end+1);
//                if(check(substring)) res.add(substring);
//            }
//        }
//        return res.size();
//    }

    private boolean check(String s){
        if(s.length() % 2 != 0) return false;
        int len = s.length() / 2;
        char[] zero = new char[len];
        Arrays.fill(zero,'0');
        char[] one = new char[len];
        Arrays.fill(one,'1');
        return s.equals(String.valueOf(zero)+String.valueOf(one)) || s.equals(String.valueOf(one)+String.valueOf(zero));
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.countBinarySubstrings("000111"));
    }
}
