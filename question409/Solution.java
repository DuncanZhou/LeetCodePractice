package question409;

/**
 * Created by duncan on 18-2-23.
 */
public class Solution {
    //找到字符串可以构造的最长回文子串
    public int longestPalindrome(String s) {
        int[] alphas = new int[52];
        for(int i = 0; i < s.length(); i++)
        {
            char a = s.charAt(i);
            if(Character.isUpperCase(a))
            {
                int index = a - 'A';
                alphas[25 + index]++;
            }else{
                int index = a - 'a';
                alphas[index]++;
            }
        }
        //统计,加上一个奇数个数最大的
        int two = 0;
        boolean flag = false;
        for(int i = 0; i < 52; i++){
            if(alphas[i] % 2 == 0)
                two += alphas[i];
            else {
                two += alphas[i] - 1;
                flag = true;
            }
        }
        if(flag)
            two++;
        return two;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.longestPalindrome("bb"));
    }
}
