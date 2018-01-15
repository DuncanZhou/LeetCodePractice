package question187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by duncan on 18-1-15.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set has = new HashSet(), repeated = new HashSet();
        for(int i = 0; i + 9 < s.length(); i++){
            String substring = s.substring(i,i+10);
            if(!has.add(substring))
                repeated.add(substring);
        }
        return new ArrayList<>(repeated);
    }
}
