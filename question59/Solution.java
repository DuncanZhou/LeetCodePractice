package question59;

/**
 * Created by duncan on 17-10-30.
 */

//生成螺旋矩阵
public class Solution {
    public int[][] generateMatrix(int n) {
        /*// Declaration
        int[][] matrix = new int[n][n];

        // Edge Case
        if (n == 0) {
            return matrix;
        }

        // Normal Case
        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = n-1;
        int num = 1; //change

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++; //change
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++; //change
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++; //change
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++; //change
            }
            colStart ++;
        }

        return matrix;*/
        int number = 1;
        int row,col;
        int[][] matrix = new int[n][n];
        for(int time = 0; time < Math.ceil(n / 2.0); time++){
            //向右
            row = time;
            col = time;
            while(col < n - time){
                matrix[row][col] = number;
                number ++;
                col++;
            }
            //向下
            col--;
            row++;
            while(row < n - time){
                matrix[row][col] = number;
                number++;
                row++;
            }
            //向左
            if(col - 1 < time)
                break;
            row --;
            col--;
            while(col >= time){
                matrix[row][col] = number;
                number++;
                col--;
            }
            //向上
            if(row - 1 < time)
                break;
            col++;
            row--;
            while(row > time){
                matrix[row][col] = number;
                number++;
                row--;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] matrix = method.generateMatrix(5);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
