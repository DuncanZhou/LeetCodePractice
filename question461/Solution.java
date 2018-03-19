package question461;

/**
 * Created by duncan on 18-3-19.
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x != 0 && y != 0){
            if((x&1) != (y&1)) count++;
            x >>= 1;
            y >>= 1;
        }
        if(x == 0 && y == 0) return count;
        int s = x == 0 ? y : x;
        while(s != 0){
            if((s&1) == 1) count++;
            s >>= 1;
        }
        return count;
    }
}
