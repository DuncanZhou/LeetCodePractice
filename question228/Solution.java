package question228;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-1-26.
 */
public class Solution {
    //找出排好序的数组中的范围
    public List<String> summaryRanges(int[] nums) {

//        for(int i=0;i<nums.length;i++){
//            int a=nums[i];
//            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
//                i++;
//            }
//            if(a!=nums[i]){
//                list.add(a+"->"+nums[i]);
//            }else{
//                list.add(a+"");
//            }
//        }


        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        int left = nums[0],right = nums[0];
        int i = 1;
        while (i < nums.length)
        {
            while(i < nums.length && nums[i] == nums[i-1])
                i++;
            if(i == nums.length)
                break;
            if(nums[i] != nums[i-1] + 1){
                if(right == left)
                    res.add(String.valueOf(left));
                else
                    res.add(String.valueOf(left)+"->"+String.valueOf(right));
                if(i <= nums.length - 1) {
                    left = nums[i ++];
                    right = left;
                }else
                    break;
            }else
                right = nums[i++];
        }
        if(left != right)
            res.add(String.valueOf(left)+"->"+String.valueOf(right));
        else res.add(String.valueOf(left));
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(method.summaryRanges(nums));
    }
}
