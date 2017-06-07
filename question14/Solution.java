package question14;

public class Solution {

	public static String longestCommonPrefix(String[] strs){
		String ret = "";
		boolean flag = true;
		if(strs == null || strs.length == 0)
			return "";
		int minlength = strs[0].length();
		for(int i = 1; i < strs.length; i++){
			if(strs[i].length() < minlength)
				minlength = strs[i].length();
		}
		for(int i = 0; i < minlength; i++){
			for(int j = 0; j < strs.length; j++){
				if(strs[j].charAt(i) != strs[0].charAt(i)){
					flag = false;
					break;
					}
			}
			if(flag == true){
				ret += strs[0].charAt(i);
			}else
				break;
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {};
		System.out.println(longestCommonPrefix(strs));
	}
}


//官方解答
//public String longestCommonPrefix(String[] strs) {
//    if (strs == null || strs.length == 0) return "";
//    for (int i = 0; i < strs[0].length() ; i++){
//        char c = strs[0].charAt(i);
//        for (int j = 1; j < strs.length; j ++) {
//            if (i == strs[j].length() || strs[j].charAt(i) != c)
//                return strs[0].substring(0, i);             
//        }
//    }
//    return strs[0];
//}
