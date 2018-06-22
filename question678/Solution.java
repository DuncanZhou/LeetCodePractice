package question678;

public class Solution {
    // * 可以代表 ( 或者 )
    public boolean checkValidString(String s) {
        return check(s.toCharArray(),0,0);
    }
    private boolean check(char[] str,int index,int count){
        if(count < 0) return false;
        if(index == str.length){
            if(count != 0) return false;
            else return true;
        }
        if(str[index] == '(') return check(str,index+1,count+1);
        else if(str[index] == ')') return check(str,index+1,count-1);
        else return check(str,index+1,count+1) || check(str,index+1,count) || check(str,index+1,count-1);
    }
}
