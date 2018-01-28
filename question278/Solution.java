package question278;

/**
 * Created by duncan on 18-1-28.
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


//recall the api, minimize the times of recalling the api
public class Solution {
    //public boolean isBadVersion(int version);
    public int firstBadVersion(int n) {
        //[1,2,...,n]
        //binary search
        int min = 1,max = n,mid;
        while(min < max){
            mid = min + (max - min) / 2;
            if(isBadVersion(mid))
                max = mid - 1;
            else
                min = mid + 1;
        }
        return isBadVersion(min) ? min : min + 1;
    }
}
