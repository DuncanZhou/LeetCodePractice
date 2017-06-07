package question4;

import java.util.ArrayList;

public class Solution {

	public double findMedianOfSortedArrays(int nums1[],int nums2[]){
		int m = nums1.length;
		int n = nums2.length;
		int median = (m + n)/2 + 1;
		double result = 0.0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count =0 ,flag1 = 0,flag2 = 0;
		while(count <= median && flag1 < nums1.length && flag2 < nums2.length){
			if(nums1[flag1] < nums2[flag2])
			{
				list.add(nums1[flag1]);
				flag1++;
				count++;
			}
			else{
				list.add(nums2[flag2]);
				flag2++;
				count++;
			}
		}
			if(flag1 == nums1.length){
				while(count <=median && flag2<nums2.length){
					list.add(nums2[flag2]);
					flag2++;
					count++;
				}
			}
			else
			{
				while(count <= median && flag1 < nums1.length){
					list.add(nums1[flag1]);
					flag1++;
					count++;
				}
			}
		if((m+n)%2==0)
			result = (list.get(median-2)+list.get(median-1))/2.0;
		else
			result = list.get(median - 1);
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {};
		int[] nums2 = {2,3};
		Solution sl = new Solution();
		System.out.println(sl.findMedianOfSortedArrays(nums1,nums2));

	}

}
