package question167;

import java.util.Arrays;

/**
 * Created by duncan on 18-1-4.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int end = len - 1,start = 0;
        while(numbers[start] + numbers[end] != target && end > start){
            if(numbers[start] + numbers[end] > target)
                end--;
            else if(numbers[start] + numbers[end] < target)
                start++;
        }
        int[] res = new int[2];
        res[0] = start+1;
        res[1] = end + 1;
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] numbers = {-2,-1,0,1};
        System.out.println(Arrays.toString(method.twoSum(numbers,-1)));
    }
}
