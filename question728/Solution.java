package question728;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-5-7.
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            boolean flag = true;
            int temp = i;
            while(temp != 0){
                int divide = temp % 10;
                if(divide == 0 || i % divide != 0){
                    flag = false;
                    break;
                }
                temp /= 10;
            }
            if(flag) res.add(i);
        }
        return res;
    }
}
