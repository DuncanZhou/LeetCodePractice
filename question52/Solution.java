package question52;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-10-29.
 */
public class Solution {
    //检查第k行第col列能不能放,与上一个皇后斜对角也不能放
    public boolean Place(int k, int col, int[] position){
        for(int i = 0; i < k; i++){
            if(position[i] == col || Math.abs(col - position[i]) == Math.abs(k - i))
                return false;
        }
        return true;
    }
    public int NQueen(int k, int[] position){
        if(k == position.length){
            return 1;
        }else{
            int total = 0;
            for(int col = 0; col < position.length; col++){
                if(Place(k,col,position)){
                    position[k] = col;
                    total += NQueen(k + 1,position);
                }
            }
            return total;
        }
    }
    public int totalNQueens(int n) {
        int[] position = new int[n];
        return NQueen(0,position);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.totalNQueens(5));
    }
}
