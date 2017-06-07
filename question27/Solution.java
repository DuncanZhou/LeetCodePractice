package question27;
//该题的解题思路与26题类似
public class Solution {

	public static int removeElement(int[] nums,int val){
		int len = 0;
		if(nums.length == 0 || (nums[0] == val && nums.length == 1))
			return len;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == val)
				continue;
			else{
				nums[len] = nums[i];
				len++;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,2,3};
		int len = removeElement(nums,3);
		System.out.println("开始输出");
		for(int i = 0; i < len; i++)
			System.out.print(nums[i]+" ");
	}
}
