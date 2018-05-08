package question593;

import java.util.Arrays;

/**
 * Created by duncan on 18-5-8.
 */
public class Solution {
    public static void main(String[] args) {

    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] disArray = new int[] {dis(p1, p2), dis(p1, p3), dis(p1, p4), dis(p2, p3), dis(p2, p4), dis(p3, p4)};
        Arrays.sort(disArray);
        return disArray[0] != 0
                && disArray[0] == disArray[1] && disArray[1] == disArray[2] && disArray[2] == disArray[3]
                && disArray[4] == disArray[5] && disArray[0] * 2 == disArray[4];
    }

    private int dis(int[] p1, int[] p2) {
        int a = p1[0] - p2[0];
        int b = p1[1] - p2[1];
        return a*a + b*b;
    }
}
