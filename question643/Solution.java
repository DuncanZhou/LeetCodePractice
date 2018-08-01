package question643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        //先加到k个
        for(int i = 0; i < k; i++)
            sum += nums[i];
        int j = k,max = sum;
        while(j < n){
            sum += nums[j];
            sum -= nums[j-k];
            if(max < sum) max = sum;
            j++;
        }
        return max * 1.0 / k;
    }
}
