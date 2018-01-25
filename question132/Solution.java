package question132;

/**
 * Created by duncan on 17-12-24.
 */
public class Solution {
    //超时
    public int res;
    public int minCut(String s) {

        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                //可划分
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];

//        res = s.length();
//        DFS(s,0);
//        return res;
    }
    public void DFS(String s,int cur){
        if(isPalindrom(s)) {
            if(cur < res)
                res = cur;
            return;
        }
        //遍历切割的位置
        for(int i = s.length()-1;i >=0;i--){
            if(isPalindrom(s.substring(i)) && cur + 1 < res){
                //可切
                DFS(s.substring(0,i),cur+1);
            }
        }
    }
    public boolean isPalindrom(String s){
        //判断s是否是回文
        int start = 0, end = s.length()-1;
        boolean flag = true;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "aabaab";
        System.out.println(method.minCut(str));
    }
}
