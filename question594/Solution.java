package question594;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by duncan on 18-4-17.
 */
public class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if(nums.length == 0 || nums.length == 1) return 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
            else map.put(nums[i],map.get(nums[i])+1);
        }
        int pre = 0,precount = 0,res = 0;
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if(precount == 0){
                pre = entry.getKey();
                precount = entry.getValue();
            }else{
                if(entry.getKey()==pre+1)
                    if(precount + entry.getValue() > res) res = precount + entry.getValue();
                pre = entry.getKey();
                precount = entry.getValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(method.findLHS(nums));
    }
}
