package com.Microsoft;

import java.util.*;

/**
 * Created by DuncanZhou on 2016/10/10.
 */
public class DeleteAdjacentWords {
    static String str;
    public boolean checkIsAdjacent(String word){
        StringBuffer wordreverse = new StringBuffer(word);
        wordreverse.reverse();
        if(str.indexOf(word) != -1 || str.indexOf(wordreverse.toString()) != -1)
            return true;
        else
            return false;
    }
    public int CountMinNumber(List<String> list){
        int count = 0;
        Map<Character,Integer> map = new HashMap();
        //初始化map
        for(int i = 0; i < str.length(); i++)
            map.put(str.charAt(i),0);
        //遍历list，如果相邻对map中的字符统计数修改
        for(int i = 0 ; i < list.size(); i++){
            String temp = list.get(i);
            if(checkIsAdjacent(temp) == true)
            {
                int count1 = map.get(temp.charAt(0));
                int count2 = map.get(temp.charAt(1));
                map.put(temp.charAt(0),++count1);
                map.put(temp.charAt(1),++count2);
            }
        }
        //将map按值进行排序,从大到小排序
        List maplist = new LinkedList(map.entrySet());
        Collections.sort(maplist, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable)((Map.Entry)(o2)).getValue()).compareTo(((Map.Entry)(o1)).getValue());
            }
        });
        Map result = new LinkedHashMap();
        for (Iterator it = maplist.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        //现在map为result,循环删光list为止
            Iterator iter = result.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                char alp = (char) entry.getKey();
                if (map.get(alp) != 0) {
                    result.put(alp, 0);
                    count++;
                    //将包含alp字母的移除list，并在map中计数减一
                    Iterator<String> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        String s = iterator.next();
                        if (s.indexOf(alp) != -1) {
                            char a0 = s.charAt(0);
                            char a1 = s.charAt(1);
                            if (map.get(a0) != 0) {
                                map.put(a0, map.get(a0) - 1);
                            }
                            if (map.get(a1) != 0) {
                                map.put(a1, map.get(a1) - 1);
                            }
                            iterator.remove();
                        }
                    }
                }
            }
            return count;
    }
    public static void main(String[] args) {
        DeleteAdjacentWords sl = new DeleteAdjacentWords();
        List<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        str = scanner.nextLine();
        int m = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < m; i++)
            list.add(scanner.nextLine());
        System.out.println(sl.CountMinNumber(list));
    }
}
