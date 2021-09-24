package hengsheng;

public class Solution1 {
    public void swap(int[] a){

        int max_i = 0;
        int min_i = a.length - 1;
        int max = a[max_i];
        int min = a[min_i];
        for (int i = 0; i < a.length; i++){
            if (a[i] > max){
                max_i = i;
            }
            if (a[i] < min){
                max_i = i;
            }
        }

        int tmp = a[0];
        a[0] = max;
        a[max_i] = tmp;

        tmp = a[a.length-1];
        a[a.length-1] = min;
        a[min_i] = tmp;
    }
}
