package question80;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duncan on 17-11-5.
 */

//移除重复的数字,最多重复两次
public class Solution {
    public int removeDuplicates(int[] nums) {
        //先排个序
        Arrays.sort(nums);
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(res.containsKey(nums[i]) && res.get(nums[i]) < 2)
                res.put(nums[i], res.get(nums[i]) + 1);
            if(!res.containsKey(nums[i]))
                res.put(nums[i], 1);
        }
        int sum = 0;
        int i = 0;
        for(Integer key:res.keySet()) {
            sum += res.get(key);
            int k = 0;
            while(k < res.get(key)) {
                nums[i++] = key;
                k++;
            }
        }
        Arrays.sort(nums,0,sum);
        System.out.println(Arrays.toString(nums));
        return sum;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.removeDuplicates(new int[]{-3,-1,0,0,0,3,3}));
    }
}
