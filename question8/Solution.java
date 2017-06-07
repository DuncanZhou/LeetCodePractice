package question8;

public class Solution {

	public static int myAtoi(String str){
		 if (str == null || str.length() == 0) return 0;  
         
	        // 2. whitespaces  
	        str = str.trim();  
	          
	        // 3. +/- sign  
	        boolean positive = true;  
	        int i = 0;  
	        if (str.charAt(0) == '+') {  
	            i++;  
	        } else if (str.charAt(0) == '-') {  
	            positive = false;  
	            i++;  
	        }  
	          
	        // 4. calculate real value  
	        double tmp = 0;  
	        for ( ; i < str.length(); i++) {  
	            int digit = str.charAt(i) - '0';  
	              
	            if (digit < 0 || digit > 9) break;  
	              
	            // 5. handle min & max  
	            if (positive) {  
	                tmp = 10*tmp + digit;  
	                if (tmp > Integer.MAX_VALUE) return Integer.MAX_VALUE;  
	            } else {  
	                tmp = 10*tmp - digit;  
	                if (tmp < Integer.MIN_VALUE) return Integer.MIN_VALUE;  
	            }  
	        }  
	          
	        int ret = (int)tmp;  
	        return ret;  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "   adf-121   ";
		System.out.println(myAtoi(str));
	}

}
