package question51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-10-29.
 */
//N后问题
public class Solution {
    //检查第k行第col列能不能放,与上一个皇后斜对角也不能放
    public boolean Place(int k, int col, int[] position){
        for(int i = 0; i < k; i++){
            if(position[i] == col || Math.abs(col - position[i]) == Math.abs(k - i))
                return false;
        }

        return true;
    }
    public void NQueen(int k, int[] position,List<List<String>> results){
        if(k == position.length){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < position.length; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < position.length; j++) {
                    if (position[i] != j)
                        row.append(".");
                    else
                        row.append("Q");
                }
                temp.add(row.toString());
            }
            results.add(temp);
        }else{
            for(int col = 0; col < position.length; col++){
                if(Place(k,col,position)){
                    position[k] = col;
                    NQueen(k + 1,position,results);
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] position = new int[n];
        NQueen(0,position,results);
        return results;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        List<List<String>> results = method.solveNQueens(5);
        System.out.println(results.size());
    }
}
