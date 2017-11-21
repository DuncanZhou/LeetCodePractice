package question71;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by duncan on 17-11-2.
 */

//简化unix路径
public class Solution {
    public String simplifyPath(String path) {


        //双端队列解决
//        Deque<String> stack = new LinkedList<>();
//        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
//        for (String dir : path.split("/")) {
//            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
//            else if (!skip.contains(dir)) stack.push(dir);
//        }
//        String res = "";
//        for (String dir : stack) res = "/" + dir + res;
//        return res.isEmpty() ? "/" : res;

        String[] newpath = path.split("/");
        Stack<String> res = new Stack<>();
        int i = 0;
        while(i < newpath.length){
            if(newpath[i].length() == 0)
            {
                i++;
                continue;
            }
            //如果是字母则加入路径
            if((newpath[i].length() > 0 && newpath[i].charAt(0) != '.') || newpath[i].length() >= 3){
                res.add(newpath[i]);
            }else if(newpath[i].length() == 2 && newpath[i].charAt(0) == '.' && newpath[i].charAt(1) == '.'){
                if(!res.isEmpty())
                    res.pop();
            }
            i ++;
        }
        String results = "";
        //将res中元素弹出,加上"/"
        while(!res.isEmpty()){
            String temp = res.pop();
            results = "/" + temp + results;
        }
        return results.toString();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
    }
}
