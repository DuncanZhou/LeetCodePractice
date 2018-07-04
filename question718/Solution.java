package question718;

public class Solution {
    public int findLength(int[] A, int[] B) {
//        int max = 0;
//        for(int i = 0; i < A.length; i++){
//            //在B中寻找
//            int j = B.length - 1;
//            while(i >= 0 && j >= 0){
//                if(A[i] == B[j]){
//                    int p = i, q = j,count = 0;
//                    while(p >= 0 && q >= 0){
//                        if(A[p--] == B[q--]) count++;
//                        else break;
//                    }
//                    if(count > max) max = count;
//                }
//                j--;
//            }
//        }
//        return max;
        //动态规划
        int max = 0;
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 1; i <= A.length; i++){
            for(int j = 1; j <= B.length; j++){
                dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
