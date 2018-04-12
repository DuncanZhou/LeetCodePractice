package question670;

import java.util.Arrays;

/**
 * Created by duncan on 18-4-12.
 */
public class Solution {
    public static void main(String[] args) {
        int num = 1993;
        System.out.println(maximumSwap(num));
    }
    public static int maximumSwap(int num) {
        StringBuilder number = new StringBuilder(String.valueOf(num));
        helper(number,0);
        return Integer.valueOf(number.toString());
    }
    private static void helper(StringBuilder number,int p){
        if(p == number.length()) return;
        //对当前数字判断是否是最大
        char cur = number.charAt(p);
        char max = cur;
        int index = 0;
        for(int i = p + 1; i < number.length(); i++){
            if(max < number.charAt(i) || (max == number.charAt(i) && i > index)){
                max = number.charAt(i);
                index = i;
            }
        }
        if(cur == max)  helper(number,p+1);
        else {
            //调换
            char temp = number.charAt(index);
            number.deleteCharAt(index);
            number.insert(index,cur);
            number.deleteCharAt(p);
            number.insert(p,temp);
            return;
        }
    }
}
