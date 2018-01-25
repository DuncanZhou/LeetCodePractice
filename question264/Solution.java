package question264;

/**
 * Created by duncan on 18-1-25.
 */
public class Solution {
//    //找到第n个ugly数字
//    public boolean check(int n){
//        //检查n是否为ugly数
//        if(n == 1 || n == 2 || n == 3 || n == 5)
//            return true;
//        while(n % 2 == 0)
//            n /= 2;
//        while (n % 3 == 0)
//            n /= 3;
//        while (n % 5 == 0)
//            n /= 5;
//        if(n == 1)
//            return true;
//        else
//            return false;
//    }
    public int nthUglyNumber(int n) {
//        //超时
//        int i = 1,count = 1;
//        while(count < n){
//            i++;
//            if(check(i))
//                count++;
//        }
//        return i;

        //这个问题最主要的就是如果按顺序找出ugly number, 那么我们如果能想到把以2, 3, 5为因子的这些ugly number分成三个list, 然后在每次输出时取list里最小的那个数输出就可以解决了
        int[] uglyNums = new int[n];
//        int uglyNums[n] = {1};
        uglyNums[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;

        for (int i = 1; i < n; ++i) {
            uglyNums[i] = Math.min(factor2, Math.min(factor3, factor5));
            if (uglyNums[i] == factor2)
                factor2 = 2 * uglyNums[++index2];
            if (uglyNums[i] == factor3)
                factor3 = 3 * uglyNums[++index3];
            if (uglyNums[i] == factor5)
                factor5 = 5 * uglyNums[++index5];
        }
        return uglyNums[n-1];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.nthUglyNumber(10));
    }
}
