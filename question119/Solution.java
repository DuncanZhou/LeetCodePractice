package question119;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-29.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> cur = new ArrayList<>();
        for(int row = 0; row < rowIndex; row++){
            cur.add(0,1);
            for(int index = 1; index < cur.size() - 1; index++)
                cur.set(index,cur.get(index) + cur.get(index + 1));
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.getRow(5));
    }
}
