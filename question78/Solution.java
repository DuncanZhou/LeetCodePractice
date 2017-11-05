package question78;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-5.
 */

//返回集合的幂集
public class Solution {
    //先写k个数的组合
    public void combination(int[] nums,int k,int index,List<Integer> current,List<List<Integer>> res){
        if(k == 0){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            combination(nums,k-1,i+1,current,res);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int k = 0; k <= nums.length; k++)
            combination(nums,k,0,current,res);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.subsets(new int[]{1,2,3,4,5}));
    }
}
