package question377;
/**
 * Created by duncan on 18-3-8.
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
//        if (target == 0) {
//            return 1;
//        }
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (target >= nums[i]) {
//                res += combinationSum4(nums, target - nums[i]);
//            }
//        }
//        return res;

        //动规
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2,3};
        int res = method.combinationSum4(nums,4);
        System.out.println(res);
    }
}
