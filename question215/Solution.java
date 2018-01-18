package question215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by duncan on 18-1-18.
 */
public class Solution {
    //返回数组中第k个大的数
    public int findKthLargest(int[] nums, int k) {
        if(k > nums.length)
            return -1;
        //用最小堆实现
        PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                    return 1;
                else if(o1 > o2)
                    return -1;
                else
                    return 0;
            }
        });
        for(int i = 0; i < nums.length; i++)
            minheap.add(nums[i]);
        int count = 1;
        while(count < k){
            minheap.poll();
            count++;
        }
        return minheap.poll();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(method.findKthLargest(nums,7));
    }
}
