package question491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by duncan on 18-4-16.
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        helper(res,cur,0,nums);
        List<List<Integer>> results = new ArrayList<>(res);
        return results;
    }
    private static void helper(Set<List<Integer>> res,List<Integer> cur, int index,int[] nums){
        if(cur.size() >= 2){
            res.add(new ArrayList<>(cur));
        }
        for(int i = index; i < nums.length; i++){
            if(cur.size() == 0 || cur.get(cur.size() -1) <= nums[i]){
                cur.add(nums[i]);
                helper(res,cur,i+1,nums);
                cur.remove(cur.size()-1);
            }
        }
    }
}
