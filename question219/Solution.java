package question219;

import java.util.HashMap;

/**
 * Created by duncan on 18-1-21.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1)
            return false;
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(nums[i])) {
                if (i - res.get(nums[i]) <= k)
                    return true;
                res.remove(nums[i]);
                res.put(nums[i],i);
            }
            res.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,1};
        System.out.println(method.containsNearbyDuplicate(nums,2));
    }
}
