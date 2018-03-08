package question378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by duncan on 18-3-8.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a0, Integer a1) {
                if (a0 > a1) {
                    return -1;
                } else if (a0 < a1) {
                    return 1;
                }
                return 0;
            }
        });// 最大堆
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if ((i + 1) * (j + 1) > k) {
                    break;
                }
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        for(int i = 1; i <= matrix.length * matrix.length; i++)
            System.out.println(method.kthSmallest(matrix,i));
    }
}
