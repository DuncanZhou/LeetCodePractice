package question398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by duncan on 18-3-11.
 */
public class Solution {
    Map<Integer,ArrayList<Integer>> map = new HashMap<>();
    Random rand = new Random();
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int index = i;
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new ArrayList<Integer>(){{add(index);}});
            else map.get(nums[i]).add(index);
        }
    }

    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}
