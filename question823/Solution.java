package question823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        long mod = (long)Math.pow(10,9) + 7;
        Arrays.sort(A);
        HashMap<Integer,Long> counter = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            counter.put(A[i],1L);
            for(int j = 0; j < i; j++){
                if(A[i] % A[j] == 0 && counter.containsKey(A[i] / A[j]))
                    counter.put(A[i],(counter.get(A[i]) + counter.get(A[j]) * counter.get(A[i] / A[j])) % mod);
            }
        }
        long res = 0;
        for(long x : counter.values())
            res = (res + x) % mod;
        return (int)res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] A = {2,4,5,10};
        System.out.println(method.numFactoredBinaryTrees(A));
    }
}
