package question496;

import java.util.Arrays;

/**
 * Created by duncan on 18-4-11.
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        int index = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == nums1[i]){
                    //寻找下一个比它大的
                    for(int cur = j + 1;cur < nums2.length; cur++)
                        if(nums2[cur] > nums1[i]){res[index] = nums2[cur];break;}
                    index++;
                    break;
                }
            }
        }
        return res;
    }
}
