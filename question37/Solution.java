package question37;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by DuncanZhou on 2016/9/5.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rowcheck = new boolean[9][10];
        boolean[][] colcheck = new boolean[9][10];
        boolean[][] gridcheck = new boolean[9][10];
        //根据board初始化三个二维判断数组
        init(board,rowcheck,colcheck,gridcheck);
        //开始DFS搜寻填的数字
        DFS(board,rowcheck,colcheck,gridcheck);
    }
    public void init(char[][] board,boolean[][] rowcheck,boolean[][] colcheck,boolean[][] gridcheck){
        for(int i = 0; i < 9; i++){
            for(int j = 0 ; j < 9; j++)
            {
                if(board[i][j] != '.'){
                    int k = i / 3 * 3 + j / 3;
                    int val = board[i][j] - '0';
                    rowcheck[i][val] = true;
                    colcheck[j][val] = true;
                    gridcheck[k][val] = true;
                }
            }
        }
    }
    public boolean DFS(char[][] board,boolean[][] rowcheck,boolean[][] colcheck,boolean[][] gridcheck){
        for(int i = 0; i < 9;i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    int gridindex = i / 3 * 3 + j / 3;
                    //开始填充,一个从1-9的循环
                    for(int k = 1; k <= 9; k++){
                        if(rowcheck[i][k] == false && colcheck[j][k] == false && gridcheck[gridindex][k] == false){
                            board[i][j] = (char)(k + '0');
                            rowcheck[i][k] = true;
                            colcheck[j][k] = true;
                            gridcheck[gridindex][k] = true;
                            if(DFS(board,rowcheck,colcheck,gridcheck) == true)
                                return true;
                            else
                            {
                                board[i][j] = '.';
                                rowcheck[i][k] = false;
                                colcheck[j][k] = false;
                                gridcheck[gridindex][k] = false;
                            }
                        }
                    }
                    //找不到填充的数字了
                    return false;
                }
            }
        }
        //没有需要填充的数字了
        return true;
    }
}
