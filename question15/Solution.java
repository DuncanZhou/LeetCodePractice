package question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> threeSum(int[] nums){
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			while(i!= 0 && nums[i] == nums[i - 1] && i < nums.length - 2 )
				i++;
			int left = i + 1;
			int right = nums.length -1;
			int sum = -nums[i];
			while(left < right){
				if(nums[left] + nums[right] == sum){
					List<Integer> templist = new ArrayList<Integer>();
					templist.add(nums[i]);
					templist.add(nums[left]);
					templist.add(nums[right]);
					list.add(templist);
					while(left < right && nums[left] == nums[left + 1])
						left++;
					while(left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				}else if(nums[left] + nums[right] < sum){
					left++;
				}else{
					right--;
				}
			}
		}
//		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
//		for(int i = 0; i < nums.length; i++){
//			int a = nums[i];
//			for(int j = i + 1; j < nums.length; j++){
//				int b = nums[j];
//				for(int k = j + 1; k < nums.length; k++){
//					int c = nums[k];
//					if(a + b + c == 0)
//					{
//						List<Integer> templist = new ArrayList<Integer>();
//						templist.add(a);
//						templist.add(b);
//						templist.add(c);
//						list.add(templist);
//					}
//				}
//			}
//		}
//		//将重复的list索引记下来
//		for(int i = 0; i < list.size(); i++){
//			for(int j = i + 1; j < list.size(); )
//			{
//				
//				if(check(list.get(i),list.get(j)) == false)
//					list.remove(j);
//				else
//					j++;
//			}
//		}
		return list;
	}
//	public static boolean check(List<Integer> list1,List<Integer> list2){
//		boolean ret = true;
//		int count = 0;
//		Collections.sort(list1);
//		Collections.sort(list2);
//		for(int i = 0; i < 3; i++)
//		{
//			if(list1.get(i) == list2.get(i))
//				count++;
//		}
//		if(count == 3)
//			ret = false;
//		return ret;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] sums = {14,4,6,-1,10,9,-8,7,-13,14,-13,-11,-8,-9,11,14,-8,-14,-13,7,-10,-15,-13,-11,-11,11,14,13,2,-14,1,-7,-2,14,-1,-15,9,7,-1,3,6,1,7,5,-1,-5,4,-2,-4,-1,-9,-7,-1,-7,-11,3,12,10,-7,-1,12,1,8,-13,1,14,9,-13,6,-7,-3,-11,2,-11,10,-14,-1,-9,0,2,5,6,3,-11,6,7,0,3,3,0,-12,-8,-13,3,-14,-5,2,10,-11,-14,-12,1,-10,5,5,7,-1,11,14,6,-10,-4,-3,8,-7,10,1,8,-1,-11,-15,-6,-12,-13,12,-11};
		System.out.println(threeSum(sums));
	}

}
