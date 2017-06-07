package question5;

public class Solution {
	public String longestPalindrome(String s){
//		String substr = Character.toString(s.charAt(0));
//		String tempstr = "";
//		int length = 1;
//		for(int i = 0; i < s.length(); i++)
//		{
//			tempstr = s.substring(i, s.length());
//			for(int j = tempstr.lastIndexOf(s.charAt(i)) + 1; tempstr.length() > 1 && tempstr.length()>length; j = tempstr.lastIndexOf(tempstr.charAt(0)) + 1){
//				tempstr = tempstr.substring(0, j );
//				StringBuilder sb = new StringBuilder(tempstr);
//				if(tempstr.equals(sb.reverse().toString()))
//				{
//					if(tempstr.length() > length){
//						length = tempstr.length();
//						substr = tempstr;
//						break;
//					}
//				}
//				tempstr = tempstr.substring(0,tempstr.length()-1);
//				if(tempstr.length() <= length)
//					break;
//			}
//		}
//		return substr;
	    int i,j,k,len=s.length(),l=0,r=1;
        for(k=len;k>=2;--k)
        {
            for(i=0;i+k<=len;++i)        
            {
                for(j=0;j<k/2;++j)
                {
                    if(s.charAt(i+j)!=s.charAt(i+k-j-1))break;
                }
                if(j!=k/2)continue;
                else
                {
                    l=i;r=k;
                }
            }
            if(r==k)break;
        }
        

        return s.substring(l,l+r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		Solution sl =new Solution();
		long starts = System.currentTimeMillis();
		System.out.println(sl.longestPalindrome(str));
		long end = System.currentTimeMillis();
		System.out.printf("Spend %f seconds",(end-starts)/1000.0);
	}

}
