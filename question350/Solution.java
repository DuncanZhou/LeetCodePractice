package question350;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by duncan on 18-1-29.
 */
public class Solution {
    //找出两个数组中的交集元素
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            if(map1.containsKey(nums1[i]))
                map1.put(nums1[i],map1.get(nums1[i])+1);
            else map1.put(nums1[i],1);
        }
        for(int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i]))
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            else map2.put(nums2[i],1);
        }
        int size = 0;
        for(Map.Entry item:map1.entrySet()){
            if(map2.containsKey(item.getKey())) {
                int temp = Math.min(map1.get(item.getKey()), map2.get(item.getKey()));
                size += temp;
                res.put((int) (item.getKey()),temp);
            }
        }
        int[] results = new int[size];
        int index = 0;
        for(Map.Entry item:res.entrySet()){
            int times = res.get(item.getKey());
            for(int i = 0; i < times; i++)
                results[index++] = (int)item.getKey();
        }
        return results;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,1,2};
        int[] res = method.intersect(nums1,nums2);
        for(int i:res)
            System.out.print(i + " ");
    }
}
