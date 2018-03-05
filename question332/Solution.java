package question332;

import java.util.*;

/**
 * Created by duncan on 18-3-5.
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> itineraryMap = new HashMap<>();
        for(String[] ticket : tickets) {
            //先对所有可到达的目的地按照字典排序
            List<String> dests = itineraryMap.get(ticket[0]);
            if(dests == null) {
                dests = new ArrayList<>();
                dests.add(ticket[1]);
                itineraryMap.put(ticket[0], dests);
            } else{
                dests.add(ticket[1]);
            }
        }
        for(List<String> dests : itineraryMap.values()) {
            Collections.sort(dests);
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        //深搜
        dfs(res, new ArrayList<String>(), itineraryMap, "JFK", tickets.length);
        return res;
    }

    private void dfs(List<String> res, List<String> cur, Map<String, List<String>> itineraryMap, String src, int len) {
        if(res.size() >1) {
            //如果已经有了解,就终止递归
            return;
        }
        if(cur.size() ==len) {
            //再用一个中间变量保存起来cur
            res.addAll(cur);
            return;
        }
        List<String> dests = itineraryMap.get(src);
        if(dests != null && dests.size() >0) {
            //遍历可到达的所有目的地
            for(int i=0;i<dests.size();i++) {
                String des = dests.remove(i);
                cur.add(des);
                dfs(res, cur, itineraryMap, des, len);
                dests.add(i, des);
                cur.remove(cur.size()-1);
            }
        }
    }
}
