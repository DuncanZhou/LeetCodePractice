package question48;

/**
 * Created by duncan on 17-10-27.
 */

//参考代码
//class Solution {
//    public:
//    void rotate(vector<vector<int> > &matrix) {
//        int i,j,temp;
//        int n=matrix.size();
//        // 沿着副对角线反转
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n - i; ++j) {
//                temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
//                matrix[n - 1 - j][n - 1 - i] = temp;
//            }
//        }
//        // 沿着水平中线反转
//        for (int i = 0; i < n / 2; ++i){
//            for (int j = 0; j < n; ++j) {
//                temp = matrix[i][j];
//                matrix[i][j] = matrix[n - 1 - i][j];
//                matrix[n - 1 - i][j] = temp;
//            }
//        }
//    }
//};

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