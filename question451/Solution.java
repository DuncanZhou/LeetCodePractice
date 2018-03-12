package question451;

import java.util.*;

/**
 * Created by duncan on 18-3-12.
 */
public class Solution {
    class Node{
        char val;
        int fre;
        Node(char c,int v){
            val = c;
            fre = v;
        }
    }
    public String frequencySort(String s) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(!map.containsKey(c)) map.put(c,1);
//            else map.put(c,map.get(c)+1);
//        }
//        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){public int compare(Node node1,Node node2){
//            if(node1.fre == node2.fre) return 0;
//            if(node1.fre > node2.fre) return -1;
//            else return 1;
//        }});
//        //遍历map
//        for(Map.Entry<Character,Integer> entry:map.entrySet())
//            queue.add(new Node(entry.getKey(),entry.getValue()));
//        String res = "";
//        while(!queue.isEmpty()){
//            Node temp = queue.poll();
//            for(int i = 0; i < temp.fre; i++)
//                res += temp.val;
//        }
//        return res;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>();
        for(Map.Entry<Character, Integer> m : map.entrySet()) {
            list.add(m);
        }

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
                return m2.getValue()-m1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> m : list) {
            for (int i = 0; i < m.getValue(); i++) {
                sb.append(m.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        String str = "ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
        System.out.println(method.frequencySort(str));
    }
}
