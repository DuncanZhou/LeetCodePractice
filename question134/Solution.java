package question134;

/**
 * Created by duncan on 17-12-26.
 */
public class Solution {
    //如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int debt = 0, remain = 0,start = 0;
        for(int i = 0; i < gas.length; i++){
            remain += gas[i] - cost[i];
            if(remain < 0)
            {
                debt += remain;
                start = i + 1;
                remain = 0;
            }

        }
        return remain + debt >= 0 ? start : -1;
//        int stations = gas.length;
//        for(int start = 0; start < stations; start++){
//            //选取不同的起始点
//            int leave = 0,index = start;
//            if(gas[index] < cost[index])
//                continue;
//            leave += gas[index] - cost[index];
//            index = (index+stations+1) % stations;
//            //从start开始
//            while((index+stations) % stations != start){
//                if(leave + gas[index] < cost[index])
//                    break;
//                leave += gas[index] - cost[index];
//                index = (index+stations+1) % stations;
//            }
//            if((index+stations) % stations == start)
//                return start;
//        }
//        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2};
        int[] cost = {1,1};
        Solution method = new Solution();
        System.out.println(method.canCompleteCircuit(gas,cost));
    }
}
