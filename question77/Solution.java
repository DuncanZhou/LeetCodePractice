package question77;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-5.
 */

//递归算法
    //list[i,k] = list[i+1,k-1] + i
public class Solution {
    public void Combine(int n,int k,int index,List<List<Integer>> res,List<Integer> current){
        if(k == 0){
            List<Integer> temp = new ArrayList<>();
            for(Integer i:current)
                temp.add(i);
            res.add(temp);
        }
        else{
            for(int i = index; i <= n; i++){
                current.add(i);
                Combine(n,k-1,i+1,res,current);
                current.remove((Object)i);
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Combine(n,k,1,res,current);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.combine(2,3));
    }
}
