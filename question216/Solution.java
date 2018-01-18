package question216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-1-18.
 */
public class Solution {
    public void combinationSum3(int k, int n,List<Integer> cur,List<List<Integer>> res,int index) {
        if(n == 0 || k == 0){
            if(n == 0 && k == 0)
                res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index; i <= 9; i++){
            if(i > n)
                return;
            cur.add(i);
            combinationSum3(k - 1, n - i, cur, res, i + 1);
            cur.remove((Object) i);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3(k,n,cur,res,1);
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        List<List<Integer>> res = method.combinationSum3(3,9);
        for(List<Integer> r:res){
            for(int i:r)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
