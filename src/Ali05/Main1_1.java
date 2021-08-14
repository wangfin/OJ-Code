package Ali05;

import java.util.Scanner;

public class Main1_1 {
    /**
     * 第一题
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] a = new int[n];
        // 读入数据
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        int max_i = -1;
        int max = Integer.MIN_VALUE;

        // 初始化左半边的值
        int left = a[0];
        // 初始化右半边的值
        int right = 0;
        for (int i = 1; i < n; i++){
            right+=a[i];
        }

        for (int i = 1; i < n; i++){
            int res = left * right;
            if (res > max){
                max = res;
                max_i = i-1;
            }
            left = left + a[i];
            right = right - a[i];
        }

        System.out.println(max_i);
    }
}
