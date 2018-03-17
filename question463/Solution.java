package question463;

/**
 * Created by duncan on 18-3-17.
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return dfs(grid,i,j,visited);
            }
        }
        return 0;
    }
    private int dfs(int[][] grid,int i,int j,boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 1 && visited[i][j] == false){
            visited[i][j] = true;
            int temp = 4;
            temp -= i - 1 >= 0 && grid[i-1][j] == 1 ? 1 : 0;
            temp -= j - 1 >= 0 && grid[i][j-1] == 1 ? 1 : 0;
            temp -= i + 1 < grid.length && grid[i + 1][j] == 1 ? 1 : 0;
            temp -= j + 1 < grid[0].length && grid[i][j+1] == 1 ? 1 : 0;
            return temp + dfs(grid,i-1,j,visited) + dfs(grid,i+1,j,visited) + dfs(grid,i,j-1,visited) + dfs(grid,i,j+1,visited);
        }
        else return 0;
    }
}
