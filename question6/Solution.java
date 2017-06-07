package question6;

public class Solution {

	public String convert(String s, int numRows){
		StringBuilder result = new StringBuilder();
		//一共numRows行
		if(numRows == 1)
			return s;
		int add1 = 2 * numRows - 2;
		int add2 = 0,index = 0;
		for(int level = 0;level < numRows;level++){
			index = level;
			int flag = 0;
			while(index < s.length()){
					result.append(s.charAt(index));
				if(flag == 0){
					index += add1;
					if(add1 == 0)
						index += add2;
					flag = 1;}
				else if(flag == 1){
					index += add2;
					if(add2 == 0)
						index += add1;
				    flag = 0;
				}
			}
			add1 -= 2;
			add2 += 2;
		}
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "PAYPALISHIRING";
		Solution sl = new Solution();
		System.out.println(sl.convert(str,3));
	}

}
