package question679;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duncan on 18-4-2.
 */
public class Solution {
    public boolean judgePoint24(int[] nums) {
//        Arrays.sort(nums);
        List<List<Double>> numbers = new ArrayList<>();
        double[] num = new double[nums.length];
        for(int i = 0; i < nums.length; i++) num[i] = nums[i];
        Permutation(num,numbers,0);
        for(List<Double> x : numbers){
            double a = x.get(0);
            double b = x.get(1);
            double c = x.get(2);
            double d = x.get(3);
            if(isValid(a,b,c,d)) return true;
        }
        return false;
    }
    private void Swap(double[] nums,int a , int b){
        double temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    //求nums数组的全排列
    public void Permutation(double[] nums,List<List<Double>> res,int index){
        if(index == nums.length){
            List<Double> temp = new ArrayList<>();
            for(double x : nums)
                temp.add(x);
            res.add(new ArrayList<Double>(temp));
            return;
        }else{
            for(int i = index; i < nums.length; i++){
                Swap(nums,i,index);
                Permutation(nums,res,index+1);
                Swap(nums,i,index);
            }
        }
    }
    private boolean isValid(double a,double b,double c,double d){
        if(isValid(a + b,c,d) || isValid(a-b,c,d) || isValid(a * b,c,d) || ( b!=0 && isValid(a / b,c,d))) return true;
        if(isValid(a,b+c,d) || isValid(a,b-c,d) || isValid(a,b*c,d) || (c!=0 && isValid(a,b / c,d))) return true;
        if(isValid(a,b,c+d) || isValid(a,b,c-d) || isValid(a,b,c*d) || (d != 0 && isValid(a,b,c / d))) return true;
        return false;
    }
    private boolean isValid(double a, double b, double c){
        if(isValid(a+b,c) || isValid(a - b,c) || isValid(a * b,c) || (b!=0 && isValid(a/b,c))) return true;
        if(isValid(a,b+c) || isValid(a, b -c) || isValid(a, b*c) || (c!=0 && isValid(a,b/c))) return true;
        return false;
    }
    private boolean isValid(double a,double b){
        if(Math.abs(a+b-24) < 0.0001 || Math.abs(a-b-24) < 0.0001 || Math.abs(a*b-24) < 0.0001 || ( b !=0 && Math.abs(a/b-24) < 0.0001)) return true;
        else return false;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {1,3,4,6};
        System.out.println(method.judgePoint24(nums));
    }
}
