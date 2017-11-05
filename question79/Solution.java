package question79;

import java.util.Arrays;

/**
 * Created by duncan on 17-11-5.
 */


//dfs搜索
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    res = dfs(board, word, 0, visited, row, col);
                }
                if(res == true)
                    return true;
                else
                    //重新给visited赋值
                    visited = new boolean[board.length][board[0].length];
            }
        }
        return res;
    }
    public boolean dfs(char[][] board,String word,int index,boolean[][] visited,int startrow,int startcol){
        //不想等或者已经访问过了
        if(board[startrow][startcol] != word.charAt(index) || visited[startrow][startcol])
            return false;
        //遍历结束
        if(index == word.length()-1)
            return true;
        visited[startrow][startcol] = true;
        boolean case1 = false,case2 = false, case3 = false, case4 = false;
        //相邻搜索
        //向上
        if(startrow > 0)
            case1 = dfs(board, word, index + 1, visited, startrow - 1, startcol);
        if(case1 == true)
            return true;
        //向下
        if(startrow < board.length - 1)
            case2 = dfs(board,word,index+1,visited,startrow+1,startcol);
        if(case2==true)
            return true;
        //向左
        if(startcol > 0)
            case3 = dfs(board,word,index+1,visited,startrow,startcol-1);
        if(case3 == true)
            return true;
        //向右
        if(startcol < board[0].length-1)
            case4 = dfs(board,word,index+1,visited,startrow,startcol+1);
        if(case4 == true)
            return true;
        //为了让visited访问数组恢复原样
        visited[startrow][startcol] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(method.exist(board,"ABCESEEEFFFS"));
    }
}
