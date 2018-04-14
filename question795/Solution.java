package question795;

/**
 * Created by duncan on 18-4-14.
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length,count = 0,left = 0,res=0;
        //记录左右边界,判断右边界在L和R范围
        for(int right = 0; right < len; right++){
            //在之间
            if(A[right] >= L && A[right] <= R){
                res += right - left + 1;
                count = right - left + 1;
            }else if(A[right] < L)
                //仍然可以有count个区间满足
                res += count;
            else{
                left = right + 1;
                count = 0;
            }
        }
        return res;
    }
}
