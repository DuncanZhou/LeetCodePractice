package question9;

public class Solution {

	public static boolean isPalindrome(int x){
		if(x < 0)
			return false;
		int length = 0;
		while((int)(x / (long)Math.pow(10, length)) > 0){
			length ++;
		}
		while(length > 1){
			int tail = x % 10;
			int head = (x / (int)Math.pow(10, length - 1)) % 10;
			if(tail != head){
				return false;
			}
			x = x / 10;
			length -= 2;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(2147483647));
	}

}
