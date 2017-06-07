package question12;

public class Solution {

	public static String intToRoman(int num){
		//I:1	V:5	X:10	L:50	C:100	D:500	M:1000	
		String[][] roman={{"","I","II","III","IV","V","VI","VII","VIII","IX"},{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},{"","M","MM","MMM"}};
		String ret = "";
		//digit记位数
		int digit = 0;
		while(num > 0){
			int number = num % 10;
			ret = roman[digit][number] + ret;
			digit++;
			num = num / 10;
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(6));
	}

}
