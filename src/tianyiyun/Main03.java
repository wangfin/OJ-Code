package tianyiyun;

import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int value_num = sc.nextInt();
        int[] values = new int[value_num];
        for (int i = 0; i < value_num; i++){
            values[i] = sc.nextInt();
        }

        int amount_num = sc.nextInt();
        int[] amounts = new int[amount_num];
        for (int i = 0; i < amount_num; i++){
            amounts[i] = sc.nextInt();
        }

        // 定义dp数组
        int[][] dp = new int[amount_num + 1][n + 1];
        // 初始化
        for (int i = 0; i <= amount_num; i++){
            dp[i][0] = 0;
        }

        // 遍历
        // 重量
        for (int i = 1; i <= amount_num; i++){
            // 背包大小
            for (int j = 1; j <= n; j++){
                if (j < amounts[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-amounts[i-1]] + values[i-1]);
                }
            }
        }
//        for (int i = 0; i <= amount_num; i++){
//            for (int j = 0; j <= n; j++){
//                System.out.println(dp[i][j]);
//            }
//        }
        System.out.println(dp[amount_num][n]);


    }
}

/**
 * 20
 * 5 4 8 6 22 2
 * 5 4 7 5 10 1
 *
 **/

// 20
//5 4 8 6 22 2
//5 4 7 5 10 1