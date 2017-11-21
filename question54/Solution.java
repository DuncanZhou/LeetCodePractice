package question54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-10-29.
 */
//螺旋矩阵
public class Solution {

//    public List<Integer> spiralOrder(int[][] matrix) {
//
//        List<Integer> res = new ArrayList<Integer>();
//
//        if (matrix.length == 0) {
//            return res;
//        }
//
//        int rowBegin = 0;
//        int rowEnd = matrix.length-1;
//        int colBegin = 0;
//        int colEnd = matrix[0].length - 1;
//
//        while (rowBegin <= rowEnd && colBegin <= colEnd) {
//            // Traverse Right
//            for (int j = colBegin; j <= colEnd; j ++) {
//                res.add(matrix[rowBegin][j]);
//            }
//            rowBegin++;
//
//            // Traverse Down
//            for (int j = rowBegin; j <= rowEnd; j ++) {
//                res.add(matrix[j][colEnd]);
//            }
//            colEnd--;
//
//            if (rowBegin <= rowEnd) {
//                // Traverse Left
//                for (int j = colEnd; j >= colBegin; j --) {
//                    res.add(matrix[rowEnd][j]);
//                }
//            }
//            rowEnd--;
//
//            if (colBegin <= colEnd) {
//                // Traver Up
//                for (int j = rowEnd; j >= rowBegin; j --) {
//                    res.add(matrix[j][colBegin]);
//                }
//            }
//            colBegin ++;
//        }
//
//        return res;
//    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowN = matrix.length;
        List<Integer> results = new ArrayList<>();
        if(rowN == 0)
            return results;
        int colN = matrix[0].length;
        if(rowN == 1){
            for(int col = 0; col < colN; col++)
                results.add(matrix[0][col]);
            return results;
        }
        if(colN == 1)
        {
            for(int row = 0; row < rowN; row++)
                results.add(matrix[row][0]);
            return results;
        }
        int row,col;
        for(int time = 0; time < Math.ceil(Math.min(rowN,colN) / 2.0); time++){
            //向右
            row = time;
            for(col = time; col < colN - time; col++)
                results.add(matrix[row][col]);
            if(row + 1 == rowN - time)
                break;
            //向下
            col --;
            for(row = row + 1; row < rowN -time; row++)
                results.add(matrix[row][col]);
            if(col - 1 < time)
                break;
            //向左
            row --;
            for(col = col - 1; col >= time; col--)
                results.add(matrix[row][col]);

            //向上
            col ++;
            for(row = row - 1; row > time; row --)
                results.add(matrix[row][col]);
        }
        return results;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] matrix = {{1,2},{3,4}};
        System.out.println(method.spiralOrder(matrix));
    }
}
