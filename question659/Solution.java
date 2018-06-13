package question659;

import java.util.HashMap;

public class Solution {
//    List<List<Integer>> results = new ArrayList<>();
    public boolean isPossible(int[] nums) {
        //定义两个HashMap,frequence记录每个数出现的频率，tail记录以该数结尾的序列个数
        HashMap<Integer,Integer> frequence = new HashMap<>();
        HashMap<Integer,Integer> tail = new HashMap<>();
        for(int x : nums) frequence.put(x,frequence.getOrDefault(x,0)+1);
        for(int x : nums){
            if(frequence.get(x) == 0) continue;
            frequence.put(x,frequence.get(x)-1);
            if(tail.getOrDefault(x-1,0) > 0){
                tail.put(x-1,tail.get(x-1)-1);
                tail.put(x,tail.getOrDefault(x,0)+1);
            }else if(frequence.getOrDefault(x+1,0) != 0 && frequence.getOrDefault(x+2,0) != 0){
                frequence.put(x+1,frequence.get(x+1)-1);
                frequence.put(x+2,frequence.get(x+2)-1);
                tail.put(x+2,tail.getOrDefault(x+2,0)+1);
            }else
                return false;
        }
        return true;
//        dfs(nums,0,new ArrayList<>());
//        if(results.size() == 0) return false;
//        else return true;
    }
//    private void dfs(int[] nums, int index, List<List<Integer>> res){
//        if(index == nums.length)
//        {
//            boolean flag = true;
//            for(List<Integer> cur : res)
//                if(cur.size() < 3){
//                    flag = false;
//                    break;
//                }
//                if (flag) results = new ArrayList<>(res);
//            return;
//        }
//        //加入，新开一个列表
//        res.add(new ArrayList<Integer>(){{add(nums[index]);}});
//        dfs(nums,index+1,res);
//        res.remove(res.size()-1);
//        ArrayList<List<Integer>> temp = new ArrayList<>(res);
//        for(int i = 0; i < res.size(); i++){
//            List<Integer> cur = res.get(i);
//            if(nums[index] == cur.get(cur.size()-1) + 1){
//                temp.get(i).add(nums[index]);
//                dfs(nums,index+1,temp);
//                temp.get(i).remove(temp.get(i).size()-1);
//            }
//        }
//    }
    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,2,3,4,5,6};
        System.out.println(method.isPossible(nums));
    }
}
