package Tenxun;

import java.util.*;

public class Main02 {
    /**
     * 1
     * 7
     * 5 4 4 2 2 5 9
     *
     * 2
     * 5
     * 7 3 1 2 3
     * 3
     * 2 10 3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0){
            T --;
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] sum = new int[n];
            int max_score = 0;
            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                sum[i] = a[i];
                if (sum[i] > max_score){
                    max_score = sum[i];
                }
            }
            // 开始算法
            for (int i = 0; i < n; i++){
                int t = i + a[i];
                if (t >= n)
                    continue;

                if (sum[i] + a[t] > sum[t]){
                    sum[t] = sum[i] + a[t];
                    if (sum[t] > max_score){
                        max_score = sum[t];
                    }

                }

            }
            System.out.println(max_score);

        }
    }
}
