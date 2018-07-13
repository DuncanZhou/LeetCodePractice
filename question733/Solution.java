package question733;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image,sr,sc,newColor,image[sr][sc],visited);
        return image;
    }
    public void dfs(int[][] image,int startx,int starty,int newColor,int startcolor,boolean[][] visited){
        if(startx < 0 || startx >= image.length || starty < 0 || starty >= image[0].length) return;
        if(image[startx][starty] == startcolor && !visited[startx][starty]) {
            visited[startx][starty] = true;
            image[startx][starty] = newColor;
            //检查和其相连的
            dfs(image,startx+1,starty,newColor,startcolor,visited);
            dfs(image,startx-1,starty,newColor,startcolor,visited);
            dfs(image,startx,starty+1,newColor,startcolor,visited);
            dfs(image,startx,starty-1,newColor,startcolor,visited);
        }
    }
}
