package question130;

import java.util.Arrays;

/**
 * Created by duncan on 17-12-19.
 */

//边界上的'O'和边界上连着的'O'不会被包裹
public class Solution {
    public void dfs(char[][] board,int rown,int coln,int i,int j){
        if(i < 0 || i >= rown || j < 0 || j >= coln || board[i][j] != 'O')
            return;
        board[i][j] = '*';
        dfs(board,rown,coln,i-1,j);
        dfs(board,rown,coln,i+1,j);
        dfs(board,rown,coln,i,j-1);
        dfs(board,rown,coln,i,j+1);
    }
    public void solve(char[][] board) {
        int rown = board.length;
        if(rown == 0)
            return;
        int coln = board[0].length;
        //遍历边界
        for(int i = 0; i < rown; i++)
        {
            dfs(board,rown,coln,i,0);
            dfs(board,rown,coln,i,coln-1);
        }
        for(int j = 0; j < coln; j++)
        {
            dfs(board,rown,coln,0,j);
            dfs(board,rown,coln,rown-1,j);
        }
        //将边界上的'*'还原为'O',其余的'O'改为'X'
        for(int i = 0; i < rown; i++){
            for(int j = 0; j < coln; j++){
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        char[][] board = {{'O','O'},{'O','O'}};
        method.solve(board);
        for(int i = 0 ; i < board.length; i++)
            System.out.println(Arrays.toString(board[i]));
    }
}
