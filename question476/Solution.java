package question476;

/**
 * Created by duncan on 18-3-28.
 */
public class Solution {
    public int findComplement(int num) {
        int temp = num,mask = 1;
        while(temp > 0){
            mask <<= 1;
            temp >>= 1;
        }
        return num ^ (mask-1);
    }
}
