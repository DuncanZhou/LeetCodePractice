package question307;

/**
 * Created by duncan on 18-2-28.
 */

//树状数组的考察
class NumArray {

    int[] sum;
    int[] num;
    private int lowbit(int x) {
        return x & (-x);
    }
    private void change(int i, int val){
        while(i < sum.length){
            sum[i] += val;
            i += lowbit(i);
        }
    }
    private int Sum(int n){
        int res = 0;
        while(n > 0){
            res += sum[n];
            n -= lowbit(n);
        }
        return res;
    }
    public NumArray(int[] nums) {
        num = nums;
        int len = nums.length;
        if(!(nums == null || nums.length == 0)){
            sum = new int[len+1];
            for(int i = 0; i < len; i++)
                change(i+1,nums[i]);
        }
    }

    public void update(int i, int val) {
        int dif = val - num[i];
        num[i] = val;
        change(i+1,dif);
    }

    public int sumRange(int i, int j) {
        return Sum(j+1) - Sum(i);
    }
}
public class Solution {
}
