package question220;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by duncan on 18-1-22.
 */
public class Solution {
    //nums[i]和nums[j]的绝对值之差最多为t,i和j的绝对值之差最多为k
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //维持一个k的窗口,利用SortedSet来判断是否有绝对值在t之间的数
        //input check
        if(k<1 || t<0 || nums==null || nums.length<2) return false;

        SortedSet<Long> set = new TreeSet<Long>();

        for(int j=0; j<nums.length; j++) {
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);
            if(!subSet.isEmpty()) return true;

            if(j>=k)
                set.remove((long)nums[j-k]);
            set.add((long)nums[j]);
        }
        return false;


//        //超时
//        for(int i = 0; i < nums.length; i++)
//            for(int j = i + 1; j <= i + k && j < nums.length; j++) {
//                if ((nums[j] == Integer.MAX_VALUE && nums[i] < 0) || (nums[i] == Integer.MAX_VALUE && nums[j] < 0))
//                    return false;
//                if (Math.abs(nums[j] - nums[i]) <= t)
//                    return true;
//            }
//        return false;
    }
}
