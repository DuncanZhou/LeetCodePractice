package question682;

import java.util.ArrayList;

public class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        ArrayList<Integer> nums = new ArrayList<>();
        for(String op : ops){
            if(op.equals("C")){
                sum -= nums.get(nums.size()-1);
                nums.remove(nums.size()-1);
            }else if(op.equals("+")){
                int temp = nums.get(nums.size()-1) + nums.get(nums.size()-2);
                sum += temp;
                nums.add(temp);
            }else if(op.equals("D")){
                int temp = 2 * nums.get(nums.size()-1);
                sum += temp;
                nums.add(temp);
            }else {
                int temp = Integer.valueOf(op);
                sum += temp;
                nums.add(temp);
            }
        }
        return sum;
    }
}
