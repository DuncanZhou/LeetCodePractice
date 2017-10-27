package question48;

/**
 * Created by duncan on 17-10-27.
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0 ; row < n/2; row++){
            for(int col = 0; col < Math.ceil(n / 2.0); col++){
                int temprow = row,tempcol = col;
                int old = matrix[temprow][tempcol];
                for(int k = 0; k < 4; k++) {
                    int temp = matrix[tempcol][n - 1 - temprow];
                    matrix[tempcol][n-1-temprow] = old;
                    old = temp;
                    int oldtemprow = temprow;
                    //temprow has changed
                    temprow = tempcol;
                    tempcol = n - 1 - oldtemprow;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Solution method = new Solution();
        method.rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}