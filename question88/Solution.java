package question88;

/**
 * Created by duncan on 17-11-7.
 */


//整合排好序的num1和num2数组
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //简洁版
//        int i=m-1, j=n-1, k=m+n-1;
//        while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
//        while (j>-1)         A[k--]=B[j--];

        int index1 = m - 1,index2 = n - 1;
        int index = m + n - 1;
        while(index >= 0){
            if(index1 < 0 || index2 < 0)
                break;
            if(nums1[index1] >= nums2[index2]) {
                nums1[index] = nums1[index1];
                index--;
                index1--;
            }else
            {
                nums1[index] = nums2[index2];
                index2--;
                index--;
            }
        }
        if(index1 != 0)
        {
            while(index1 >= 0) {
                nums1[index] = nums1[index1];
                index--;
                index1--;
            }
        }
        if(index2 != 0)
        {
            while(index2 >= 0) {
                nums1[index] = nums2[index2];
                index--;
                index2--;
            }
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();

    }
}
