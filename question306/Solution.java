package question306;

/**
 * Created by duncan on 18-2-27.
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {

        int L = num.length();

        //确定第一个数，最终用num.subStr(0,i)来确定第一个数，所以i可以用来标示第一个数的长度，
        //但是下标i不包含在第一个数中
        for(int i=1;i<=(L-1)/2;i++){

            //如果长度大于等于2，则不能以0开头
            if(num.startsWith("0") && i>=2) break;

            //确定第二个数，第一个数用num.subStr(i,j),包括i，不包括j，所以长度为j-i,
            //第三个数从下标j开始，长度最长为L-1-j+1，即L-j
            for(int j=i+1;(L-j)>=i && (L-j)>=j-i;j++){
                if(num.charAt(i)=='0' && j-i>=2) break;

                long num1 = Long.parseLong(num.substring(0,i));
                long num2 = Long.parseLong(num.substring(i,j));

                if(isAdditive(num.substring(j), num1, num2)){
                    return true;
                }
            }
        }


        return false;
    }

    //判断由num1,num2和后续的字串能否构成加法序列
    public boolean isAdditive(String remain,long num1,long num2){

        if(remain.equals("")) return true;

        long sum = num1+num2;

        String sumStr = ""+sum;
        if(!remain.startsWith(sumStr)) return false;

        return isAdditive(remain.substring(sumStr.length()), num2, sum);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.isAdditiveNumber("112358"));
    }
}
