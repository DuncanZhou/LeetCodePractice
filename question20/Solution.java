package question20;

import java.util.Stack;

public class Solution {

	public static boolean isValid(String s){
		boolean ret = false;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{')
				stack.push(s.charAt(i));
			else
			{
				if(!stack.isEmpty()){
					char a = (char)stack.pop();	
					if((c == ')' && a != '(') || (c == ']' && a != '[') || (c == '}' && a != '{'))
						return false;	
					ret = true;
				}else
					return false;
			}
		}
		if(!stack.isEmpty())
			return false;
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{[]"));
	}

}
