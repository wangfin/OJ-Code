package Kedaxunfei;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i ++){
            a[i] = sc.nextInt();
        }
        // i与i+1交换，其实也就是最多+1
        int max_len = 0;
        // 遍历
        for (int i = 0; i < n; i ++){

            int len = 0;
            int j;
            for (j = i; j < n; j++){
                if ( j < n - 2 && a[j] != a[i] && a[j+1] != a[i]){
                    break;
                }
                if (a[j] == a[i]){
                    len++;
                }

            }
            if (j < n - 1 && a[j+1] == a[i]){
                len++;
            }

            if (len > max_len){
                max_len = len;
            }

        }
        System.out.println(max_len);

    }
}
