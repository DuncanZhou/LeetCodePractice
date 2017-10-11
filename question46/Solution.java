package question46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-10-11.
 */
//枚举
public class Solution {
    public void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void perm(int[] nums,int index,List<List<Integer>> results){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int a:nums)
                temp.add(a);
            results.add(temp);
        }
        for(int i = index; i < nums.length; i++){
            swap(nums,i,index);
            perm(nums,index + 1,results);
            swap(nums,i,index);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        perm(nums,0,results);
        return results;
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> results = method.permute(nums);
        for(List<Integer> list:results){
            System.out.println(list);
        }
    }
}
