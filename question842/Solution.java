package question842;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-5-30.
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        if(S.length() == 1) return new ArrayList<>();
        if(S.charAt(0) == '0'){
            int a = 0;
            for(int second = 2; second < S.length(); second++){
                try{
                    int b = Integer.valueOf(S.substring(1,second));
                    List<Integer> res = new ArrayList<>();
                    res.add(a);
                    res.add(b);
                    if (solve(b, a + b, S.substring(second), res)) return res;
                }catch (Exception e){
                    continue;
                }
            }
        }else {
            //寻找第一个和第二个
            for (int first = 1; first < S.length(); first++) {
                try {
                    int a = Integer.valueOf(S.substring(0, first));
                    for (int second = first + 1; second < S.length(); second++) {
                        try {
                            int b = Integer.valueOf(S.substring(first, second));
                            List<Integer> res = new ArrayList<>();
                            res.add(a);
                            res.add(b);
                            if (solve(b, a + b, S.substring(second), res)) return res;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return new ArrayList<>();
    }
    public boolean solve(int pre,int sum, String S,List<Integer> res){
        int len = String.valueOf(sum).length();
        if(S.length() == 0) return true;
        if(S.length() < len) return false;
        if(Integer.valueOf(S.substring(0,len)) == sum) {
            res.add(sum);
            return solve(sum, pre + sum, S.substring(len),res);
        }
        else return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.splitIntoFibonacci("0123"));
    }
}
