package question310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duncan on 18-3-1.
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaf = new ArrayList<>();
        if(n<=1) {
            leaf.add(0);
            return leaf;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++) graph.put(i, new ArrayList<>());
        int[] neighbors = new int[n];
        for(int[] edge : edges) {
            neighbors[edge[0]]++;
            neighbors[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++) {
            if(graph.get(i).size() ==1 ) leaf.add(i);
        }
        while(n>2) {
            List<Integer> newLeaf = new ArrayList<>();
            for(int l : leaf) {
                n--;
                for(int nb : graph.get(l)) {
                    if(--neighbors[nb] == 1) newLeaf.add(nb);
                }
            }
            leaf = newLeaf;
        }
        return leaf;
    }


}
