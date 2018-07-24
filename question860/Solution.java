package question860;

public class Solution {
    //是否能找零，付钱5、10、20。找零5或者15
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[3];
        for(int bill : bills){
            if(bill == 5) changes[0]++;
            if(bill == 10){
                if(changes[0] == 0) return false;
                else{
                    changes[0]--;
                    changes[1]++;
                }
            }
            if(bill == 20){
                //先把10的找出去
                if(changes[1] != 0){
                    if(changes[0] != 0){
                        changes[1]--;
                        changes[0]--;
                    }
                    else return false;
                }else if(changes[0] >= 3){
                    changes[0] -= 3;
                }else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution method = new Solution();
        int[] bills = {5,5,10,10,20};
        System.out.println(method.lemonadeChange(bills));
    }
}
