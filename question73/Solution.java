package question73;

/**
 * Created by duncan on 17-11-3.
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean tr = false, tc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0)
                        tr = true;
                    if(j == 0)
                        tc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(tr == true){
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if(tc == true){
            for(int j = 0; j < matrix.length; j++)
                matrix[j][0] = 0;
        }
    }
}
