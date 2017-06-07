package question39;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by DuncanZhou on 2016/9/7.
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> as = new ArrayList<List<Integer>>();
        Solution sl = new Solution();
        as = sl.combinationSum(nums,target);
        System.out.println(as);
    }
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        //先将数组排序
        Arrays.sort(candidates);
        search(candidates,target,new ArrayList<Integer>(),0);
        return result;
    }
    public void search(int[] nums, int target, List<Integer> ret, int start){
        if(target == 0) {
            List<Integer> list = new ArrayList<Integer>(ret);
            result.add(list);
        }
        for(int j = start; j < nums.length && nums[j] <= target; j++){
            ret.add(nums[j]);
            search(nums,target - nums[j],ret,j);
            ret.remove(new Integer(nums[j]));
        }
    }
}
