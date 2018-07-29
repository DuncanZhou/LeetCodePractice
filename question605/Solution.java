package question605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean pre = false;
        for(int i = 0 ; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                pre = true;
                continue;
            }
            if(pre == true && flowerbed[i] == 0){
                pre = false;
                continue;
            }
            if(!pre && flowerbed[i] == 0){
                if(i < flowerbed.length - 1 && flowerbed[i+1] == 0) n--;
                else if(i == flowerbed.length - 1) n--;
                pre = true;
            }
        }
        if(n <= 0) return true;
        else return false;
    }
}
