package question498;

public class Solution {
    //打印矩阵
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int startx = 0, starty = 0, row = matrix.length, col = matrix[0].length, count = 0,dir = 1;
        int[] res = new int[row * col];

        for(int i = 0; i < row * col; i++){
            res[count++] = matrix[startx][starty];
            if(dir == 1){
                if(startx == 0){
                    if(starty != col - 1) starty++;
                    else startx++;
                    //换方向了
                    dir *= -1;
                }else if(starty == col - 1){
                    startx++;
                    dir *= -1;
                }
                else {
                    startx--;
                    starty++;
                }
            }else{
                if(startx == row - 1){
                    starty++;
                    //换方向了
                    dir *= -1;
                }else if(starty == 0){
                    startx++;
                    dir *= -1;
                }
                else {
                    startx++;
                    starty--;
                }
            }
        }
        return res;
    }
}
