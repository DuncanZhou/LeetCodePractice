package HeapSort;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution method = new Solution();
        int[] arr = {9,8,7,6,5,4,3,2,1};
        method.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void heapSort(int[] arr){
        //先构造大顶堆或(小顶堆)
        for(int i = arr.length / 2 - 1; i >= 0; i--)
            shift(arr,i,arr.length);

        //大元素移至末尾
        for(int i = arr.length - 1; i > 0; i--){
            Swap(arr,0,i);
            //继续调整
            shift(arr,0,i);
        }
    }
    private void shift(int[] arr, int i, int len){
        int temp = arr[i];
        for(int k = 2 * i + 1; k < len; k = 2 * i + 1){
            //找大的
            if(k + 1 < len && arr[k + 1] > arr[k])
                k++;
            if(arr[k] > temp){
                //交换
                arr[i] = arr[k];
                i = k;
            }else
                break;
        }
        arr[i] = temp;
    }

    private void Swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
