package question813;

public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        //动态规划
        //dp[k][i] = max{dp[k-1][j] + sum[j...i] / (i - j + 1)}
        //先计算sum[j...i]
        int[][] sum = new int[A.length][A.length];
        for(int step = 0; step < A.length; step++){
            for(int i = 0; i + step < A.length; i++){
                sum[i][i+step] = step == 0 ? A[i] : sum[i][i+step-1] + A[i+step];
            }
        }
        double[][] dp = new double[K+1][A.length];
        //初始化
        for(int i = 0; i < A.length; i++)
            dp[1][i] = i == 0 ? A[i] : (dp[1][i-1] * i + A[i]) * 1.0 / (i + 1);
        for(int s = 2; s <= K; s++){
            for(int i = 0; i < A.length; i++){
                for(int j = 0; j < i; j++){
                    dp[s][i] = Math.max(dp[s][i],dp[s-1][j] + sum[j + 1][i] * 1.0 / (i - j));
                }
            }
        }
        return dp[K][A.length-1];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {9,1,2,3,9};
        System.out.println(method.largestSumOfAverages(nums,3));
    }
}
