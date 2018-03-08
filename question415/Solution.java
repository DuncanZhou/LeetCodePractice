package question415;

/**
 * Created by duncan on 18-2-24.
 */
public class Solution {
    public String addStrings(String num1, String num2) {

        //简洁版本
//        StringBuilder sb = new StringBuilder();
//        int i = num1.length() - 1, j = num2.length() - 1;
//        int carry = 0;
//        while (i >= 0 || j >= 0) {
//            if (i >= 0) {
//                carry += num1.charAt(i) - '0';
//                i--;
//            }
//            if (j >= 0) {
//                carry += num2.charAt(j) - '0';
//                j--;
//            }
//            sb.append(carry % 10);
//            carry /= 10;
//        }
//        if (carry != 0) {
//            sb.append(carry);
//        }
//        return sb.reverse().toString();



        StringBuilder res = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1, flag = 0;
        while(i >= 0 && j >= 0){
            int temp = num1.charAt(i)- '0' + num2.charAt(j)-'0' + flag;
            if(temp >= 10)
            {
                flag = 1;
                res.append(String.valueOf(temp -10));
            }else{
                flag = 0;
                res.append(String.valueOf(temp));
            }
            i--;
            j--;
        }
        int k = i == -1 ? j : i;
        String num = i == -1 ? num2 : num1;
        while(k >= 0){
            int temp = num.charAt(k) -'0' + flag;
            if(temp >= 10){
                flag = 1;
                res.append(String.valueOf(temp-10));
            }else{
                flag = 0;
                res.append(String.valueOf(temp));
            }
            k--;
        }
        if(flag == 1)
            res.append('1');
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.addStrings("123","87"));
    }
}
