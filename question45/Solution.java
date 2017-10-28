package question45;

/**
 * Created by duncan on 17-10-28.
 */

//dp[i,j] = min{dp[i,k]+dp[k,j]}
    //到第j个位置到nums.length位置所要步数

    //贪心的条件是：当前跳跃+下次跳跃的总距离最远。
public class Solution {

    public int jump(int[] nums) {
        //超时,这种动态规划和遍历时间复杂度都是O(n^2)
//        int [][] dp = new int[nums.length][nums.length];
//        //初始化
//        for(int i = 0; i < nums.length; i++){
//            for(int j = 1; i +j < nums.length && j <= nums[i]; j++){
//             dp[i][j + i] = 1;
//            }
//        }
//        //dp
//        for(int step = 1; step < nums.length; step++){
//            for(int i = 0; i + step < nums.length;i++){
//                int j = i + step;
//                if(j - i <= nums[i])
//                    dp[i][j] = 1;
//                else if(j - i == 1)
//                    dp[i][j] = 2;
//                else
//                {
//                    int min = Integer.MAX_VALUE;
//                    for(int k = i + 1; k < j; k++)
//                        min = Math.min(dp[i][k] + dp[k][j],min);
//                    dp[i][j] = min;
//                }
//            }
//        }
//        return dp[0][nums.length - 1];

        //range是当前的一个区域范围,nextrange是下一步可达最远范围
        if(nums.length == 1)
            return 0;
        int range = 0;
        int nextrange = 0;
        int step = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > range){
                if(i <= nextrange){
                    step++;
                    range = nextrange;
                }else
                    return -1;
            }
            if(i + nums[i] > nextrange)
                nextrange = i + nums[i];
            if(i == nums.length - 1)
                return step;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {2,3,1,1,1,4};
        System.out.println(method.jump(nums));
    }
}
