package question433;

/**
 * Created by duncan on 18-6-5.
 */
public class Solution {
    int res = -1;
    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0) return res;
        int i;
        for(i = 0; i < bank.length; i++)
            if(bank[i].equals(end)) break;
        if(i == bank.length) return res;
        boolean[] visited = new boolean[bank.length];
        dfs(start,end,bank,visited,0);
        return res;
    }
    private void dfs(String start,String end,String[] bank,boolean[] visited,int cur){
        if(start.equals(end)){
            if(res != -1) res = Math.min(cur,res);
            else res = cur;
        }
        for(int i = 0; i < bank.length; i++){
            if(visited[i]) continue;
            //diff = 1
            char[] temp = bank[i].toCharArray();
            int diff = 0;
            for(int j = 0; j < temp.length; j++){
                if(start.charAt(j) != temp[j]) diff++;
            }
            if(diff == 1){
                visited[i] = true;
                dfs(bank[i],end,bank,visited,cur+1);
                visited[i] = false;
            }
        }
    }
}
