package question13;

public class Solution {

	public static int RomanToint(String roman){
		int ret = toNumber(roman.charAt(0));
		for(int i = 1; i < roman.length(); i++){
			if(toNumber(roman.charAt(i - 1)) < toNumber(roman.charAt(i))){
				ret += toNumber(roman.charAt(i)) - 2 * toNumber(roman.charAt(i - 1));
			}else{
				ret += toNumber(roman.charAt(i));
			}
		}
		return ret;
	}
	 public static int toNumber(char ch) {  
	        switch (ch) {  
	            case 'I': return 1;  
	            case 'V': return 5;  
	            case 'X': return 10;  
	            case 'L': return 50;  
	            case 'C': return 100;  
	            case 'D': return 500;  
	            case 'M': return 1000;  
	        }  
	        return 0;  
	   } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RomanToint("MMMCMXCIX"));
	}

}
