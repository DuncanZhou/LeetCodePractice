package question118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 17-11-29.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
//        ArrayList<Integer> row = new ArrayList<Integer>();
//        for(int i=0;i<numRows;i++)
//        {
//            row.add(0, 1);
//            for(int j=1;j<row.size()-1;j++)
//                row.set(j, row.get(j)+row.get(j+1));
//            allrows.add(new ArrayList<Integer>(row));
//        }
//        return allrows;



        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        res.add(new ArrayList<Integer>(){{add(1);}});
        if(numRows == 1)
            return res;
        res.add(new ArrayList<Integer>(){{add(1);add(1);}});
        if(numRows == 2)
            return res;
        int row = 3;
        while(row <= numRows){
            List<Integer> temp = new ArrayList<Integer>(){{add(1);}};
            List<Integer> lastRow = res.get(res.size()-1);
            //遍历上一层
            for(int i = 0; i < lastRow.size() - 1; i++)
                temp.add((lastRow.get(i) + lastRow.get(i + 1)));
            temp.add(1);
            res.add(temp);
            row ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.generate(5));
    }
}
