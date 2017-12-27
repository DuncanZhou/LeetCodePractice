package question137;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duncan on 17-12-27.
 */
public class Solution {
    //数组中每个数都出现了3次,除了一个数,找到那个数
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums != null && nums.length == 1)
            return nums[0];
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        List<Integer> filter = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maps.put(nums[i], 1);
            } else {
                if (!filter.contains(nums[i])) {
                    if (maps.get(nums[i]) == null) {
                        maps.put(nums[i], 1);
                    } else {
                        maps.put(nums[i], maps.get(nums[i]) + 1);
                    }

                    if (maps.get(nums[i]) > 1) {
                        maps.remove(nums[i]);
                        filter.add(nums[i]);
                    }
                }
            }
        }
        return maps.keySet().toArray(new Integer[0])[0];
    }
}
