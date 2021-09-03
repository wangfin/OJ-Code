package PDD;

import java.util.Scanner;

public class Solution1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            // T组数据
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < n; i++){
                int min = Integer.MIN_VALUE;
                int min_j = -1;
                for (int j = 0; j < m; j++){
                    if (b[j] == -1){
                        continue;
                    }
                    int val = Math.abs(a[i] - b[j]);
                    if (val <= k && val > min){
                        min_j = j;
                        min = val;
                    }
                }
                if (min_j != -1){
                    b[min_j] = -1;
                    ans++;
                }
            }
            System.out.println(ans);

        }
    }
}
