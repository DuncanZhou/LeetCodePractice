package question200;

/**
 * Created by duncan on 18-1-15.
 */
public class Solution {
    //统计grid中岛屿的个数
    public void dfs(char[][] grid, boolean[][] visited,int i,int j){
        //与其相邻是否有为1的
        visited[i][j] = true;
        //上
        if(i > 0 && visited[i-1][j] == false && grid[i-1][j] == '1')
            dfs(grid,visited,i-1,j);
        //下
        if(i + 1 < grid.length && visited[i+1][j] == false && grid[i+1][j] == '1')
            dfs(grid,visited,i + 1,j);
        //左
        if(j > 0 && visited[i][j-1] == false && grid[i][j-1] == '1')
            dfs(grid,visited,i,j-1);
        //右
        if(j + 1 < grid[0].length && visited[i][j+1] == false && grid[i][j+1] == '1')
            dfs(grid,visited,i,j+1);
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;
        int res = 0;
        //dfs
        boolean [][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == false){
                    res ++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        char[][] grid = {};
        System.out.println(method.numIslands(grid));
    }
}
