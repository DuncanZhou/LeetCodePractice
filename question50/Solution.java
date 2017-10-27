package question50;

import static java.lang.Math.pow;

/**
 * Created by duncan on 17-10-27.
 */

//pow(x,n) = pow(x,n/2)*pow(x,n-n/2)

public class Solution {

    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        else{
            double half = pow(x,n / 2);
            return half * half * pow(x,n%2);
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.myPow(-2,-3));
    }
}
