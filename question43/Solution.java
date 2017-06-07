package question43;

/**
 * Created by duncan on 17-6-7.
 */
public class Solution {
    //给字符串后面添加num个0
    public String addZero(String string,int num){
        StringBuilder stringBuilder = new StringBuilder(string);
        for(int i = 0; i < num; i++)
            stringBuilder.append('0');
        return stringBuilder.toString();
    }
    //字符串相加
    public String add(String num1,String num2){
        StringBuilder result = new StringBuilder();
        int num1len = num1.length();
        int num2len = num2.length();
        int i = num1len - 1,j = num2len - 1;
        int jinwei = 0,temp;
        while(i >= 0 || j >= 0){
            if(i < 0)
            {
                temp = num2.charAt(j) - '0' + jinwei;
            }
            else if(j < 0)
                temp = num1.charAt(i) - '0' + jinwei;
            else
                temp = num1.charAt(i) - '0' + num2.charAt(j) - '0' + jinwei;
            jinwei = 0;
            if(temp >= 10){
                jinwei = 1;
                temp -= 10;
            }
            result.append((char)(temp + '0'));
            i--;
            j--;
        }
        if(jinwei == 1)
            result.append('1');
        return result.reverse().toString();
    }
    //两个字符相乘
    public String multiplyBychar(char a,char b){
        int ma = a - '0';
        int mb = b - '0';
        return String.valueOf(ma * mb);
    }
    //两个长度小于110的字符串相乘
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        String result = "0";
        //对其中一个字符串循环
        int count1 = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            char a = num1.charAt(i);
            //用a分别乘num2
            int count2 = 0;
            String temp = "0";
            for(int j = num2.length() - 1; j >= 0; j--){
                String first = multiplyBychar(a,num2.charAt(j));
                temp = add(temp,addZero(first,count2));
                count2 ++;
            }
            result = add(result,addZero(temp,count1));
            count1++;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        String str1 = "9133";
        String str2 = "0";
        System.out.println(sl.multiply(str1,str2));
    }
}
