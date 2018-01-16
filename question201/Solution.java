package question201;

/**
 * Created by duncan on 18-1-16.
 */
public class Solution {
    public int bits(int a){
        int count = 1;
        while(a / 2 > 0)
        {
            count++;
            a /= 2;
        }
        return count;
    }
    //返回m到n之间所有数相与的结果
    public int rangeBitwiseAnd(int m, int n) {
        if(bits(n) > bits(m))
            return 0;
        int res = m;
        for(int i = m; i <= n; i++) {
            res = res & i;
            if(res == 0 || i == n)
                break;
        }
        return res;

        //等价于 求 m 与 n 二进制编码中 同为1的前缀
//        int count = 0;
//        while(n != m)
//        {
//            m >>= 1;
//            n >>= 1;
//            count++;
//        }
//        return (m<<count);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.rangeBitwiseAnd(2147483646,2147483647));
    }
}
