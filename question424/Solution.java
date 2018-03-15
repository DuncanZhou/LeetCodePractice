package question424;

/**
 * Created by duncan on 18-3-15.
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;
        int max = 0;
        int[] ch = new int[26];
        char[] str = s.toCharArray();
        for(int i=0, j=0; i<s.length(); i++){
            while(j < s.length()){
                ch[str[j] - 'A']++;
                if(count(ch) > k){  //If exceed k, break
                    ch[str[j] - 'A']--;
                    break;
                }
                j++;
            }
            //保存当前最大值
            max = Math.max(max, j-i);
            //下一处
            ch[str[i] - 'A']--;
        }
        return max;
    }
    //统计出频率最高的字母,返回需要变化的字母个数
    public int count(int[] ch){
        int max = 0;
        int sum = 0;
        for(int val:ch){
            sum += val;
            max = Math.max(max, val);
        }
        return sum - max;
    }
}
