package question38;

/**
 * Created by DuncanZhou on 2016/9/6.
 */
public class Solution {
    public String countAndSay(int n){
        String temp = "1";
        for(int i = 1;i < n; i++){
            temp = readoff(temp);
        }
        return temp;
    }
    public String readoff(String s){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int index = i,count = 0;
            char num = s.charAt(i);
            while(index < s.length() && s.charAt(index) == num) {
                count++;
                index++;
            }
            stringBuilder.append((char)(count + '0'));
            stringBuilder.append(s.charAt(i));
            i = index;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "1";
        Solution sl = new Solution();
        System.out.println(sl.countAndSay(1));
    }
}
