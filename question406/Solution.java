package question406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by duncan on 18-3-15.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){public int compare(int[] a, int[] b){if(a[0] == b[0]) return a[1] - b[1]; else if(b[0] - a[0] > 0) return 1; else return -1;}});
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] x : people){
            res.add(x[1],x);
        }
        int[][] results = new int[people.length][2];
        for(int i = 0; i < res.size(); i++)
            results[i] = res.get(i);
        return results;
    }
}
