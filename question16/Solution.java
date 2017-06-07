package question16;

import java.util.Arrays;

public class Solution {

	public static int threeSumsClosest(int[] nums,int target){
		Arrays.sort(nums);
		int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
		int result = nums[0] + nums[1] + nums[2];
		int left,right;
		for(int i = 0; i < nums.length - 2; i++){
			left = i + 1;
			right = nums.length - 1;
			while(left < right){
				if(nums[i] + nums[left] + nums[right] > target){
					if(Math.abs(nums[i] + nums[left] + nums[right] - target) < min){
						result = nums[i] + nums[left] + nums[right];
						min = Math.abs(nums[i] + nums[left] + nums[right] - target);
					}
					right--;
				}else if(nums[i] + nums[left] + nums[right] < target){
					if(Math.abs(nums[i] + nums[left] + nums[right] - target) < min){
						result = nums[i] + nums[left] + nums[right];
						min = Math.abs(nums[i] + nums[left] + nums[right] - target);
					}
					left++;
				}else{
					result = nums[i] + nums[left] + nums[right];
					return result;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {0,0,0};
		System.out.println(threeSumsClosest(nums,1));
	}

}
