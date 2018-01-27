package question240;

/**
 * Created by duncan on 18-1-27.
 */
public class Solution {
    //在满足条件的二维矩阵中搜索一个数
    //矩阵每一行从左到右,每一列从上到下是排好序的,
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0])
            return false;
        int rowN = matrix.length;
        int colN = matrix[0].length;
        for(int i = 0; i < rowN; i++){
            if(matrix[i][colN-1] < target)
                continue;
            if(matrix[i][0] > target)
                return false;
            for(int j = 0; j < colN; j++){
                if(matrix[i][j] == target)
                    return true;
                if(matrix[i][j] > target)
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] matrix = {{5},{6}};
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(method.searchMatrix(matrix, 6));
    }
}
