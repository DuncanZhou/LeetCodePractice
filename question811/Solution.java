package question811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        ArrayList<String> results = new ArrayList<>();
        HashMap<String,Integer> res = new HashMap<>();
        for(String str: cpdomains){
            String[] temp = str.split(" ");
            int times = Integer.valueOf(temp[0]);
            //原字符串加入
            res.put(temp[1],res.getOrDefault(temp[1],0)+times);
            String sub = "";
            String[] subdomains = temp[1].split("\\.");
            for(int i = subdomains.length-1; i > 0; i--) {
                if(sub.equals("")) sub = subdomains[i];
                else sub = subdomains[i] + "." + sub;
                res.put(sub, res.getOrDefault(sub, 0) + times);
            }
        }
        //整理成list

        for (Map.Entry<String,Integer> entry:res.entrySet())
            results.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        return results;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(method.subdomainVisits(cpdomains).toString());
    }
}
