package question881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length,right = len - 1,left = 0,res = 0;
        //先排个序
        Arrays.sort(people);
        while(left <= right){
            if(people[left] + people[right] <= limit){
                res++;
                right --;
                left ++;
            }else{
                right --;
                res++;
            }
        }
        return res;
    }
}
