package question312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-3-1.
 */
public class Solution {
    //深搜超时
    int max = 0;
    public int maxCoins(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for(int n : nums)
//            res.add(n);
//        maxCoins(res,0);
//        return max;
        //DP: the result depends on the last burst balloon, which seprate the array into 2 subarray.
        //DP: by adding 1 to head and tail, DP[i,i] = 0 and DP[i,i+2] = num[i] * num[i+1] * num[i+2]
        //不包括边界
        int n = nums.length+2;
        int[] newnums = new int[n];
        for (int i = 0;i < n - 2; i++){
            newnums[i+1] = nums[i];
        }
        newnums[0] = newnums[n - 1] = 1;
        int[][] DP = new int[n][n];
        for (int k = 2; k < n; k++){
            for (int l = 0; l + k < n; l++){
                int h = l + k;
                for (int m = l + 1; m < h; m++){
                    DP[l][h] = Math.max(DP[l][h],newnums[l] * newnums[m] * newnums[h] + DP[l][m] + DP[m][h]);
                }
            }
        }
        return DP[0][n - 1];
    }
    public void maxCoins(List<Integer> nums, int cur){
        if(nums.size() == 1){
            if(cur + nums.get(0) > max)
                max = cur + nums.get(0);
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            int old = nums.get(i);
            int size = nums.size();
            nums.remove(i);
            if(i == 0)
                maxCoins(nums,cur + old * nums.get(i));
            else if(i == size - 1)
                maxCoins(nums,cur + old * nums.get(i-1));
            else
                maxCoins(nums,cur + old * nums.get(i-1) * nums.get(i));
            nums.add(i,old);
        }
    }
}
