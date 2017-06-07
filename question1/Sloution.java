package question1;

public class Sloution {

	public int[] twoSum(int[] nums,int target){
		int flag = 0;   //目前未找到
		int[] result = new int [2];
		for(int i=0;i < nums.length;i++){
			for(int j=i+1;j < nums.length;j++){
				if(nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
					flag = 1;    //找到了
					break;
				}
			}
			if(flag == 1)
				break;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int [] nums =  new int[]{2,7,11,15};
         int target = 17;
         Sloution sl = new Sloution();
         int [] result = new int [2];
         result = sl.twoSum(nums, target);
         System.out.println(result[0]+","+result[1]);
	}

}
