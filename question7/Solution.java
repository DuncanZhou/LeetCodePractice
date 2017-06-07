package question7;

public class Solution {
	public static int reverse(int x){
		int number = Math.abs(x);
		int result = Math.abs(number % 10);
		number = Math.abs(number / 10);
		while(number > 0){
			if(((long)result * 10 + number % 10) > Integer.MAX_VALUE)
				return 0;
			else
				result = result * 10 + number % 10;
			number = number / 10;
		}
		if(x < 0)
			result = result * (-1);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-2147483648));
	}

}
