package question89;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by duncan on 17-11-8.
 */

// G(i)=i ^ (i / 2)
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) result.add(i ^ i>>1);
        return result;
    }

    public static void main(String[] args) {
        Solution method =  new Solution();
        System.out.println(method.grayCode(3));
    }
}
