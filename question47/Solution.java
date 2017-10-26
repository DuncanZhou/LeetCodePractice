package question47;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by duncan on 17-10-26.
 */
public class Solution {
    public void Swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void Permute(int[] nums, int index,List<List<Integer>> results){
        if(index == nums.length)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length; i++)
                temp.add(nums[i]);
            results.add(temp);
        }
        else{

            for(int i = index; i < nums.length; i++){
                boolean flag = false;
                for(int j = index; j <= i - 1; j++)
                    if(nums[j] == nums[i]) {
                        flag = true;
                        break;
                    }
                if(flag == false) {
                    Swap(nums, i, index);
                    Permute(nums, index + 1, results);
                    Swap(nums, i, index);
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Permute(nums,0,results);
        return results;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {2,1,1};
        System.out.println(method.permuteUnique(nums));
    }
}
