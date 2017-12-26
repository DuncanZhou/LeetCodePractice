package question134;

/**
 * Created by duncan on 17-12-26.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stations = gas.length;
        for(int start = 0; start < stations; start++){
            //选取不同的起始点
            int leave = 0,index = start;
            if(gas[index] < cost[index])
                continue;
            leave += gas[index] - cost[index];
            index = (index+stations+1) % stations;
            //从start开始
            while((index+stations) % stations != start){
                if(leave + gas[index] < cost[index])
                    break;
                leave += gas[index] - cost[index];
                index = (index+stations+1) % stations;
            }
            if((index+stations) % stations == start)
                return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2};
        int[] cost = {1,1};
        Solution method = new Solution();
        System.out.println(method.canCompleteCircuit(gas,cost));
    }
}
