package question565;

/**
 * Created by duncan on 18-4-22.
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            int temp = dfs(nums,visited,i);
            max = Math.max(temp,max);
        }
        return max;
    }
    private int dfs(int[] nums,boolean[] visited,int cur){
        if(!visited[cur]){
            visited[cur] = true;
            return 1 + dfs(nums,visited,nums[cur]);
        }
        return 0;
    }
}
