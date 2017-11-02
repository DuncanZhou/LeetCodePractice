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
        StringBuilder results = new StringBuilder();
        //将res栈重新转换
        Stack<String> newres = new Stack<>();
        while(!res.isEmpty())
            newres.add(res.pop());
        //将res中元素弹出,加上"/"
        while(!newres.isEmpty()){
            String temp = newres.pop();
            results.append('/');
            for(int k = 0; k < temp.length(); k++)
                results.append(temp.charAt(k));
        }
        if(results.length() == 0)
            results.append('/');
        return results.toString();
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        System.out.println(method.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
    }
}
