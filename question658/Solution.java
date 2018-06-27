package question658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(k == 0) return res;
        int index = Find(arr,x);
        if(index == 0)
            for(int i = 0; i < k; i++) res.add(arr[i]);
        else if(index == arr.length)
            for(int i = arr.length-1; i >= arr.length - k; i--) res.add(arr[i]);
        else{
            res.add(arr[index]);
            int left = index - 1, right = index + 1;
            while(res.size() < Math.min(k,arr.length)){
                if(left < 0 && right == arr.length) break;
                if(left < 0) {
                    res.add(arr[right++]);
                    continue;
                }
                if(right == arr.length){
                    res.add(arr[left--]);
                    continue;
                }
                if(Math.abs(x - arr[left]) == Math.abs(x - arr[right])){
                    if(arr[left] < arr[right]){
                        res.add(arr[left]);
                        left--;
                    }
                    else{
                        res.add(arr[right]);
                        right++;
                    }
                }
                else if(left >= 0 && Math.abs(x - arr[left]) < Math.abs(x - arr[right])){
                    res.add(arr[left]);
                    left--;
                }else{
                    res.add(arr[right]);
                    right++;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    //二分法查找
    private int Find(int[] arr,int target){
        int start = 0, end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] arr = {0,1,1,1,2,3,6,7,8,9};
        List<Integer> res = method.findClosestElements(arr,9,4);
        for(int x : res) {
            System.out.print(x);
            System.out.print(" ");
        }
    }
}
