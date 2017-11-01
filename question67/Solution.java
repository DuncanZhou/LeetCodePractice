package question67;

/**
 * Created by duncan on 17-11-1.
 */
//二进制加法
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int alen = a.length();
        int blen = b.length();
        int extra = 0,i = alen - 1,j = blen - 1;
        while(i >= 0 || j >= 0){
            int temp;
            if(j == -1)
                temp = a.charAt(i) - '0' + extra;
            else if(i == -1)
                temp = b.charAt(j) - '0' + extra;
            else
                temp = a.charAt(i) + b.charAt(j) - 2 * '0' + extra;
            if(temp >= 2){
                extra = 1;
                res.append((char)(temp - 2 + '0'));
            }else {
                extra = 0;
                res.append((char) (temp + '0'));
            }
            if(i >= 0)
                i--;
            if(j >= 0)
                j--;
        }
        if(extra == 1)
            res.append((char)(1 + '0'));
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.addBinary("1010","1011"));
    }
}
