package question31;

//该题目的意思是找到比当前数列大一点点的数列，如果找不到则将该数列倒序排列
/**
 * Created by DuncanZhou on 2016/8/29.
 */
public class Solution {
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void reverse(int[] nums,int start, int end){
        int i,j;
        for(i = start,j = end; i < j; i++,j--){
            swap(nums,i,j);
        }
    }
    public static void nextPermutation(int[] nums){
        int index = -1;
        if(nums.length == 1 || nums.length == 0)
            return;
        //从后往前找到不是递增的数
        for(int i = nums.length - 1; i > 0; i--)
        {
            int j = i - 1;
            if(nums[j] < nums[i])
            {
                index = j;
                break;
            }
        }
        if(index == -1){
            reverse(nums,0,nums.length - 1);
            return;
        }
        //从后往前找到大于该数的第一个数，并交换
        for(int i = nums.length - 1; i > index; i--)
        {
            if(nums[i] > nums[index]){
                swap(nums,index,i);
                break;
            }
        }
        //从index后面的数倒序
        reverse(nums,index + 1,nums.length - 1);
    }
    public static void main(String[] args){
        int[] nums = {6,5,4,3,2,1};
        nextPermutation(nums);
        for(int i = 0; i < 6; i++)
            System.out.print(nums[i]+" ");
    }
}
