package question263;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by duncan on 18-1-24.
 */
public class Solution {
    //如果这个数的质因子只包含2,3,5,那么这个数就是ugly的
    public boolean isUgly(int num) {
        Set<Integer> ugly = new HashSet<Integer>(){{add(2);add(3);add(5);}};
        if(num == 1 || ugly.contains(num))
            return true;
        while(num > 1){
            if(num % 2 == 0)
                num /= 2;
            else if(num % 3 == 0)
                num /= 3;
            else if(num % 5 == 0)
                num /= 5;
            else
                break;
        }
        if(num == 1)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.isUgly(19));
    }
}
