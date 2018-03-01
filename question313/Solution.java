package question313;

import java.util.Arrays;

/**
 * Created by duncan on 18-3-1.
 */
public class Solution {
    //丑数的翻版,用一个数组来记录primes的索引
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1)
            return 1;
        //索引每个primes的位置
        int[] indexes = new int[primes.length];
        int[] results = new int[n];
        results[0] = 1;
        Arrays.fill(indexes,0);
        int count = 1;
        while(count < n){
            int index = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < indexes.length; i++)
                if(results[indexes[i]] * primes[i] < min){
                    min = results[indexes[i]] * primes[i];
                    index = i;
                }
            //等于min的index都要++
            for(int i = 0; i < indexes.length; i++)
                if(results[indexes[i]] * primes[i] == min)
                    indexes[i]++;
            results[count] = min;
            count++;
        }
        return results[n-1];
    }
}
