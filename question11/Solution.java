package question11;

public class Solution {
	public static int maxArea(int[] height){
		//最开始的边界是[left,right]
		int left = 0,right = height.length - 1,k;
		int result = ((height[left] < height[right] ? height[left]:height[right]) * (right - left));
		while(left < right){
			result = result > ((height[left] < height[right] ? height[left]:height[right]) * (right - left)) ? result:((height[left] < height[right] ? height[left]:height[right]) * (right - left));
			if(height[left] < height[right]){
				k = left;
				while(k < right && height[k] <= height[left])
					k++;
				left = k;
			}
			else{
				k = right;
				while(k > left && height[k] <= height[right])
					k--;
				right = k;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] height = {1,2,4,3};
		System.out.println(maxArea(height));
	}

}
