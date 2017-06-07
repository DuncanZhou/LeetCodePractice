package question40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DuncanZhou on 2016/9/8.
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        int target = 4;
        List<List<Integer>> as = new ArrayList<>();
        Solution sl = new Solution();
        as = sl.combinationSum2(nums,target);
        System.out.println(as);
    }
    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        Arrays.sort(candidates);
        search(new ArrayList<Integer>(),target,0,candidates);
        return result;
    }
    public void search(List<Integer> ret,int target,int start,int[] nums){
        if(target == 0){
            List<Integer> temp = new ArrayList<>(ret);
            if(!result.contains(temp))
                result.add(temp);
        }
        for(int i = start; i < nums.length && nums[i] <= target; i++){
            ret.add(nums[i]);
            search(ret,target - nums[i],i + 1,nums);
            ret.remove((Integer)nums[i]);
        }
    }
}
