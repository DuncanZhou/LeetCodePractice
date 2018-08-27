package question777;

public class Solution {
    public boolean canTransform(String start, String end) {
        /*
        如果start能变换到end，那么除去两个字符串中的"X"，剩余的字符串一定相同。因为任意"R"和"L"的相对顺序都不会发生变化，我们定义出去"X"的字符串为有效字符串
根据变换的规则，"L"不能向右移，“R”不能向左移，所以 start 中“L”对应的 index "i" 一定不小于 end 中 “L”对应的index "j"；start 中“R”对应的 index "i" 一定不大于 end 中 “R”对应的index "j"；
         */
        if(start.length() != end.length()) return false;
        String s1 = "",s2 = "";
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) != 'X') s1 += start.charAt(i);
            if(end.charAt(i)  != 'X') s2 += end.charAt(i);
        }
        if(!s1.equals(s2)) return false;
        int sr = 0, sl = 0,el = 0,er = 0;
        for (int i = 0; i< start.length(); i++){
            if (start.charAt(i) == 'R') sr++;
            if (end.charAt(i) == 'L') el++;
            if (start.charAt(i) == 'L') sl++;
            if (end.charAt(i) == 'R') er++;

            //因为start中l可以左移，r可以右移
            if (sl > el || sr < er) return false;
        }

        return true;
    }
//    private boolean helper(String start,String end){
//
//    }
    public static void main(String[] args) {
        Solution method = new Solution();
//        System.out.println(method.canTransform("XXXXXLXXXX","LXXXXXXXXX"));
        System.out.println(method.canTransform("RXXLRXRXL","XRLXXRRLX"));
    }
}
