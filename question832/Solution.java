package question832;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        reverse(A);
        invert(A);
        return A;
    }
    //翻转
    private void reverse(int[][] A){
        for(int[] row: A){
            int left = 0,right = row.length - 1;
            while(left < right){
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
    //invert
    private void invert(int[][] A){
        for(int[] row: A){
            for(int i = 0; i < row.length; i++)
                row[i] = 1 - row[i];
        }
    }
}
