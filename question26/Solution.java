package question26;

public class Solution {

	public static int removeDuplicates(int[] nums){
		int len = nums.length;
		if(len == 1)
			return len;
		int now;
		for(int i = 0; i < len; i++){
			int t = i + 1;
			now = nums[i];
			while(t < len && nums[t] == now)
				t++;
			//不一样直接下一个去判断
			if(t == i + 1)
				continue;
			//后面都是重复的，不用一个一个判断了，直接返回数组长度
			if(t == len)
			{
				len = len - (len - i) + 1;
				break;
			}
			//有一样的，开始覆盖
			int cur = t;
			//开始向前覆盖
			int temp1,temp2;
			for(temp1 = i + 1, temp2 = cur; temp1 < len && temp2 < len; temp1++,temp2++)
				nums[temp1] = nums[temp2];
			len = len - (temp2 - temp1);
		}
		return len;
		//参考解法
//		  int len = A.length;
//		    if (len == 0)
//		        return 0;
//		    int count = 1;
//		    for (int i = 1; i < len; i++) {
//		        if (A[i] == A[i - 1]) {
//		            continue;
//		        }else{
//		            A[count] = A[i];
//		            count++;
//		        }
//		    }
//		    return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,3,4,4,5};
		System.out.println(removeDuplicates(nums));
		for(int i = 0; i < removeDuplicates(nums); i++)
			System.out.print(nums[i]+" ");
	}

}
