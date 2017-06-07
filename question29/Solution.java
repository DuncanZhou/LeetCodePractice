package question29;

/**
 * Created by DuncanZhou on 2016/8/20.
 */

//num=a_0*2^0+a_1*2^1+a_2*2^2+…+a_n*2^n
public class Solution {
    public static int divide(int dividend,int divisor){
        boolean isNeg = (dividend >= 0) ^ (divisor >= 0);

        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);

        long quotient = 0;
        while(divid>=divis) {
            long k = divis;
            int i = 0;
            while((k<<1)<divid) {
                k = k<<1;
                ++i;
            }
            divid -= k;
            quotient += 1<<i;
        }

        if(quotient > Integer.MAX_VALUE && !isNeg) return Integer.MAX_VALUE;

        return (int) (isNeg? -quotient : quotient);
    }

    public static void main(String[] args){
        System.out.println(divide(-2147483648,-1));
    }
}
