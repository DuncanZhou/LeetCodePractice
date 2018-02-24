package question414;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by duncan on 18-2-24.
 */
//自己实现比较器
class MyCompare implements Comparator{
    public int compare(Object o1,Object o2){
        int n1 = (int)o1;
        int n2 = (int)o2;
        if(n1 == n2)
            return 0;
        return n1 > n2 ? -1 : 1;
    }
}
public class Solution {
    //返回数组中不重复的第三个最大的数
    public int thirdMax(int[] nums) {
        TreeSet<Integer> res = new TreeSet<Integer>(new MyCompare());
        for(int i = 0; i < nums.length; i++)
            res.add(nums[i]);
        Iterator<Integer> iterator = res.iterator();
        if(res.size() < 3)
            return iterator.next();
        int count = 1;
        while(count < 3) {
            iterator.next();
            count++;
        }
        return iterator.next();
    }
    public static void main(String[] args) {
        Solution method = new Solution();
        int[] nums = {2,1,1};
        System.out.println(method.thirdMax(nums));
    }
}
