package question28;

/**
 * Created by DuncanZhou on 2016/8/17.
 */
public class Solution {
    public static int strStr(String haystack,String needle){
        if(haystack.isEmpty() && needle.isEmpty())
            return 0;
        //java中字符串的匹配就是采用的KMP算法
        return haystack.indexOf(needle);
    }
    public static void main(String[] args){
        String Str = "mississippi";
        String str = "issippisadfasdf";
        System.out.println(strStr(Str,str));
    }
}

