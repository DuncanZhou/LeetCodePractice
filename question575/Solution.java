package question575;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by duncan on 18-4-14.
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        int total = candies.length / 2;
        Set<Integer> has = new HashSet<>();
        for(int x : candies)
        {
            if(has.size() == total) break;
            if(!has.contains(x))
                has.add(x);
        }
        return has.size();
    }
}
