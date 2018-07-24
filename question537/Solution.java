package question537;

public class Solution {
    //计算两个复数相乘，返回字符串格式
    public String complexNumberMultiply(String a, String b) {
        String[] a_results = a.split("\\+");
        String[] b_results = b.split("\\+");
        int a1 = Integer.valueOf(a_results[0]);
        int a2 = Integer.valueOf(a_results[1].substring(0,a_results[1].length()-1));
        int b1 = Integer.valueOf(b_results[0]);
        int b2 = Integer.valueOf(b_results[1].substring(0,b_results[1].length()-1));
        StringBuilder res = new StringBuilder();
        int res1 = a1 * b1 - a2 * b2;
        int res2 = a1 * b2 + a2 * b1;
        res.append(res1);
        res.append("+");
        res.append(res2);
        res.append("i");
        return res.toString();
    }
}
