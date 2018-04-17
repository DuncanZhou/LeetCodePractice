package question766;

/**
 * Created by duncan on 18-4-17.
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rowN = matrix.length, colN = matrix[0].length;
        for(int  col = 0; col < colN; col++){
            int crow = 0,ccol = col,pre = matrix[crow][ccol];
            while(crow + 1 < rowN && ccol + 1 < colN){
                if(matrix[++crow][++ccol] != pre) return false;
            }
        }
        for(int row = 0; row < rowN; row++){
            int crow = row, ccol = 0,pre = matrix[crow][ccol];
            while(crow + 1 < rowN && ccol + 1 < colN){
                if(matrix[++crow][++ccol] != pre) return false;
            }
        }
        return true;
    }
}
