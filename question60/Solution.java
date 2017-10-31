package question60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by duncan on 17-10-31.
 */
//返回全排列的第k个
public class Solution {
//    public void Swap(int[] nums,int a, int b){
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }
//    public  String Permutation(int[] nums, int index, List<String> results, int k){
//        if(index == nums.length){
//                StringBuilder temp = new StringBuilder();
//                for(int i = 0; i < nums.length;i++)
//                    temp.append(nums[i]);
//                results.add(temp.toString());
//                if(results.size() == k)
//                    return results.get(k-1);
//        }else{
//            for(int i = index; i < nums.length; i++){
//                int[] temp = nums.clone();
//                Swap(nums,index,i);
//                Arrays.sort(nums,Math.min(index + 1,nums.length - 1),nums.length);
//                String res = Permutation(nums,index + 1,results,k);
//                if(res != "")
//                    return res;
//                Swap(nums,index,i);
//                nums = temp;
//            }
//        }
//        return "";
//    }
    public String getPermutation(int n, int k) {
//        List<String> res = new ArrayList<>();
//        int[] nums = new int[n];
//        for(int i = 0; i < n; i++){
//            nums[i] = i + 1;
//        }
//        return Permutation(nums,0,res,k);

        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++)
            num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = i*fact[i-1];
        //num中从0开始存储
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = new int[]{5,4,3,2,1};
        Arrays.sort(nums,1,4);
//        System.out.println(Arrays.toString(nums));
        System.out.println(method.getPermutation(3,5));
    }
}
