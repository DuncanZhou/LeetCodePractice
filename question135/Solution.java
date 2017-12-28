package question135;


import java.util.Arrays;

/**
 * Created by duncan on 17-12-28.
 */


public class Solution {
    public int candy(int[] ratings) {
        int num = ratings.length;
        int[] candy = new int[num];
        //初始化candy
        Arrays.fill(candy,1);
        //确保右边比左边的多
        for(int i = 1; i < num; i++)
            if(ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
        //从右往左扫描
        for(int i = num - 2; i >= 0; i--)
            if(ratings[i] > ratings[i+1])
                candy[i] = Math.max(candy[i+1] + 1,candy[i]);
        int sum = 0;
        for(int c:candy)
            sum += c;
        return sum;

    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] ratings = {1,2,3,4,5};
        System.out.println(method.candy(ratings));
    }
}
