package question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static List<List<Integer>> fourSum(int[] nums,int target){
		//先将数组排序
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length == 3)
		{
			return result;
		}
		for(int i = 0; i < nums.length - 2; i++){
			if(i != 0 && nums[i] == nums[i - 1])
				continue;
			int Left = i;
			int Right = nums.length - 1;
			while(Left < Right){
				int left = Left + 1;
				int right = Right - 1;
				while(left < right){
					if(nums[Left] + nums[left] + nums[right] + nums[Right] < target && left < right){
						left++;
					}else if(nums[Left] + nums[left] + nums[right] + nums[Right] > target && left < right){
						right--;
					}else if(nums[Left] + nums[left] + nums[right] + nums[Right] == target && left < right){
						ArrayList<Integer> templist = new ArrayList<Integer>();
						templist.add(nums[left]);
						templist.add(nums[right]);
						templist.add(nums[Left]);
						templist.add(nums[Right]);
						result.add(templist);
						while(left < nums.length -1 && nums[left] == nums[left + 1])
							left++;
						left++;
						while(right > 0 && nums[right] == nums[right - 1])
							right--;
						right--;
					}
				}
				while(Right > 0 && nums[Right] == nums[Right - 1])
					Right--;
				if(Left < Right)
					Right--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-5,-5,-3,2,5,0,4};
		System.out.println(fourSum(nums,-7));
	}

}
