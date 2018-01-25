package question179;

/**
 * Created by duncan on 18-1-14.
 */
public class Solution {

    // Comparator to decide which string should come first in concatenation
//    Comparator<String> comp = new Comparator<String>(){
//        @Override
//        public int compare(String str1, String str2){
//            String s1 = str1 + str2;
//            String s2 = str2 + str1;
//            return s2.compareTo(s1); // reverse order here, so we can do append() later
//        }
//    };
//
//		Arrays.sort(s_num, comp);


    public int compare(int a, int b){
        String num1 = String.valueOf(a);
        String num2 = String.valueOf(b);
        String res1 = num1 + num2;
        String res2 = num2 + num1;
        for(int i = 0; i < res1.length(); i++){
            if(res1.charAt(i) > res2.charAt(i))
                return 1;
            else if(res1.charAt(i) < res2.charAt(i))
                return -1;
        }
        return 0;
    }
    public String largestNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 0; j < nums.length -1 - i;j++){
                if(compare(nums[j],nums[j+1]) < 0)
                {
                    int swap = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = swap;
                }
            }
        }
        String res = "";
        for(int i = 0; i < nums.length;i++)
            res += String.valueOf(nums[i]);
        if(res.charAt(0) == '0')
            return "0";
        return res;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.compare(12,121));
        int [] nums = {824,938,1399,5607,6973,5703,9609,4398,8247};
        System.out.println(method.largestNumber(nums));
    }
}
