package Tenxun;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int[] speed = new int[n];
        for (int i = 0; i < n; i++){
            speed[i] = sc.nextInt();
        }
        // 结果
        int res = 0;

        // 开始遍历
        for(int i = 0; i < speed.length; i++){
            int num = 0;
            // 最大值
            int max = speed[i];
            // 最小值
            int min = speed[i];
            // 相差不超过10
            for(int j = 0; j < speed.length; j++){
                if (Math.abs(speed[j] - max) < 10 && Math.abs(speed[j] - min) < 10){
                    num++;
                    if (speed[j] > max){
                        max = speed[j];
                    }else if (speed[j] < min){
                        min = speed[j];
                    }
                }
            }
            res = Math.max(res, num);
        }
        System.out.println(res);

    }
}
