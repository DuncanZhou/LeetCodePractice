package question762;

public class Solution {
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for(int i = L; i <= R; i++)
            if(isPrime(CountOne(i))) res++;
        return res;
    }
    // Integer.bitCount()统计1的个数
    private int CountOne(int num){
        int flag = 1,count = 0;
        while(flag != 0){
            if((num & flag) != 0) count++;
            flag <<= 1;
        }
        return count;
    }
    private boolean isPrime(int num){
        int i;
        if(num == 2) return true;
        for(i = 2; i < num; i++)
            if(num % i == 0) break;
        if(i == num) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.countPrimeSetBits(842,888));
    }
}
