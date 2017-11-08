package question90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by duncan on 17-11-8.
 */

//找出有重复元素集合的幂集
public class Solution {
    //得到大小为k的子集集合
    public void subset(int[] nums,List<Integer> cur, List<List<Integer>> res,int k,int index){
        List<Integer> last = new ArrayList<>();
        if(k == 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }else{
            boolean flag = false;
            for(int i = index; i < nums.length; i++){
                //flag控制了重复的元素往后加可以加,而在移除重复元素之后再往里面加重复的则加入不了
                if(i != 0 && flag == true && nums[i-1] == nums[i])
                    continue;
                cur.add(nums[i]);
                flag = true;
                subset(nums,cur,res,k-1,i+1);
                cur.remove((Object)nums[i]);

            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int k = 0; k <= nums.length; k++)
            subset(nums,cur,res,k,0);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.subsetsWithDup(new int[]{1,2,2,3,3}));
    }
}
