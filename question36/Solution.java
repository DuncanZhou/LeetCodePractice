package question36;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DuncanZhou on 2016/9/3.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board){
        boolean ret = true;
        Set<Character> Rowset = new HashSet<Character>();
        Set<Character> Colset = new HashSet<Character>();
        //行和列一起判断
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    if ((board[i][j] != '.' && Rowset.contains(board[i][j])) || (board[j][i] != '.' && Colset.contains(board[j][i]))) {
                        ret = false;
                        return ret;
                    } else {
                        if(board[i][j] != '.')
                            Rowset.add(board[i][j]);
                        if(board[j][i] != '.')
                            Colset.add(board[j][i]);
                    }
            }
            Rowset.clear();
            Colset.clear();
        }
        //判断每个格子
        Set<Character> Gridset = new HashSet<Character>();
        int count = 0,rowindex = 0, colindex = 0;
        while(count < 9){
            int i = rowindex,j = colindex;
            //如果列的索引超出边界，则换下一列
            if(j == 9)
                colindex = 0;
            //判断完一个格子
            for(i = rowindex; i < rowindex + 3; i++){
                for(j = colindex; j < colindex + 3; j++){
                    if(board[i][j] != '.') {
                        if (Gridset.contains(board[i][j])) {
                            ret = false;
                            return ret;
                        } else
                            Gridset.add(board[i][j]);
                    }
                }
            }
            //rowindex和colindex进行更新
            Gridset.clear();
            count++;
            if(count % 3 == 0)
                rowindex += 3;
            colindex += 3;
        }
        return ret;
    }

    public static void main(String[] args) {
        char[][] test = {"..4...63.".toCharArray(),".........".toCharArray(),"5.......9".toCharArray(),"...56....".toCharArray(),"4.3.....1".toCharArray(),"...7.....".toCharArray(),"...5.....".toCharArray(),".........".toCharArray(),".........".toCharArray()};
        Solution sl = new Solution();
        System.out.println(sl.isValidSudoku(test));
    }
}
