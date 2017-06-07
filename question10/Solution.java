package question10;

public class Solution {

	public static boolean isMatch(String s,String p){
		if(s == null || p == null)
			return false;
		if(p.length() == 0)
			return s.length() == 0;
		if(p.length() == 1)
			return (s.length() == 1) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		if(p.charAt(1) == '*'){
			//可以有1个或多个
			while(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
				if(isMatch(s,p.substring(2)))
					return true;
				s = s.substring(1);
			}
			//0个的情况，则从第二个开始匹配
			return isMatch(s,p.substring(2));
		}
		else{
			if(s.length() == 0)
				return false;
			else
				return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1),p.substring(1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("aa","a*"));
	}
}
