package question761;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by duncan on 18-4-13.
 */
public class Solution {
    //清奇的解法,海平面交换
    public String makeLargestSpecial(String S) {
        int count = 0,start = 0;
        List<String> res = new ArrayList<>();
        for(int j = 0; j < S.length(); j++){
            if(S.charAt(j) == '1') count++;
            else count--;
            if(count == 0){
                //递归求解
                res.add('1'+makeLargestSpecial(S.substring(start+1,j))+'0');
                start = j + 1;
            }
        }
        Collections.sort(res,Collections.reverseOrder());
        return String.join("",res);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "11011000";
        System.out.println(method.makeLargestSpecial(str));
    }
}
