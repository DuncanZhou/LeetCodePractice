package question830;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        char[] strs = S.toCharArray();
        int start = 0,i;
        for(i = 0; i < strs.length; i++){
            if(strs[i] != strs[start]){
                if(i - start >= 3){
                    //可以加入
                    int end = i - 1,index = start;
                    List<Integer> temp = new ArrayList<Integer>(){{add(index);add(end);}};
                    res.add(temp);
                }
                start = i;
            }
        }
        //最后的再判断
        if(i - start >= 3){
            int end = i - 1,index = start;
            List<Integer> temp = new ArrayList<Integer>(){{add(index);add(end);}};
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "abxxxxyyyf";
        Solution method = new Solution();
        for(List<Integer> temp : method.largeGroupPositions(S)){
            for(int x : temp)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
