package question849;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        //找连续的0的最大长度
        int max = 0,pre = -1,len = seats.length,leftmax = 0,rightmax = 0;
        for(int i = 0; i < len; i++){
            if(seats[i] == 1) {
                if(pre == -1) leftmax = i - pre - 1;
                if(i - pre - 1 > max) max = i - pre - 1;
                pre = i;
            }
        }
        //最后结尾还要再算下
        if(pre != len - 1) rightmax = len - 1 - pre;
        if(max == 1 || max == 2) max = 1;
        else max = (int)Math.ceil(max / 2.0);
        max = Math.max(max,leftmax);
        return Math.max(max,rightmax);
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] seats = {1,0,1};
        System.out.println(method.maxDistToClosest(seats));
    }
}
