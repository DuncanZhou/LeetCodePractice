package question329;

/**
 * Created by duncan on 18-3-3.
 */
public class Solution {
    public int DFS(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        //改进：记录下每一个访问过的点的最大长度，当重新访问到这个点的时候，就不需要重复计算
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int max = 1;
        for (int k = 0; k < dir.length; k++) {
            int x = i + dir[k][0], y = j + dir[k][1];
            if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
                continue;
            } else {
                if (matrix[x][y] > matrix[i][j]) {
                    //这里当前结点只算长度1,然后加上dfs后子路径的长度，比较得出最大值
                    int len = 1 + DFS(matrix, x, y, cache);
                    max = Math.max(max, len);
                }
            }
        }
        cache[i][j] = max;
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = DFS(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
