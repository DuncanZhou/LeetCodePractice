package question74;

/**
 * Created by duncan on 17-11-3.
 */

//搜索矩阵,每一行排序,每一行的第一个元素大于上一行的最后一个元素
public class Solution {
    //二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        //在每行末尾做二分查找,在定位到行后再做二分查找
        int rowN = matrix.length;
        if(rowN == 0)
            return false;
        int colN = matrix[0].length;
        if(colN == 0)
            return false;
        int low = 0, high = rowN-1;
        int mid = (low + high) / 2;
        while(low <= high){
            mid = (low + high) / 2;
            if(matrix[mid][colN - 1] > target)
                high = mid - 1;
            else if(matrix[mid][colN - 1] < target)
                low = mid + 1;
            else
                return true;
        }
        //定位到mid这一行
        int current = mid;
        if(matrix[mid][colN-1] < target)
            current = mid + 1;
        if(current >= rowN)
            return false;
        low = 0;
        high = colN - 1;
        while(low <= high){
            mid = (low + high ) / 2;
            if(matrix[current][mid] > target)
                high = mid - 1;
            else if(matrix[current][mid] < target)
                low = mid + 1;
            else
                return true;
        }
        if(matrix[current][mid] != target)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Solution method =  new Solution();
        System.out.println(method.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20}},3));
    }
}
