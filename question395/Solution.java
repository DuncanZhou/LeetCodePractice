package question395;

/**
 * Created by duncan on 18-3-12.
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringSub(s, k, 0, s.length() - 1);
    }

    private int longestSubstringSub(String s, int k, int start, int end){
        if(start > end) return 0;
        int[] count = new int[26];
        for(int i = start; i <= end; i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] > 0 && count[i] < k){
                int pos = s.indexOf((char)(i + 'a'), start);
                return Math.max(longestSubstringSub(s, k, start, pos - 1), longestSubstringSub(s, k, pos + 1, end));
            }
        }
        return end - start + 1;
    }
}
