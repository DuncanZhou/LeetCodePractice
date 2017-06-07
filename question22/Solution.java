package question22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	final static char[] parenthsis = {'(',')'};
	public static List<String> generateParenthsis(int n){
		List<String> ret = new ArrayList<String>();
		StringBuilder substr = new StringBuilder();
		dfs(ret,n,substr);
		return ret;
	}
	public static void dfs(List<String> ret,int n,StringBuilder substr){
		
		if(substr.length() == 2 * n  )
		{
			if(Check(substr.toString()))
				ret.add(substr.toString());
			return;
		}
			for(int j = 0; j < 2; j++)
			{
				char c = parenthsis[j];
				substr.append(c);
				dfs(ret,n,substr);
				substr.deleteCharAt(substr.length() - 1);
			}
	}
	public static boolean Check(String str){
		boolean ret = true;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c == '(')
				stack.push(c);
			else
			{
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		if(!stack.isEmpty())
			return false;
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthsis(4));
	}

}
