package xiecheng;

import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < m; j ++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        // 第一行
        for (int j = 1; j < m; j++){
            dp[0][j] = dp[0][j-1] + Math.abs(arr[0][j] - arr[0][j-1]);
        }
        // 第一列
        for (int i = 1; i < n; i ++){
            dp[i][0] = dp[i-1][0] + Math.abs(arr[i][0] - arr[i-1][0]);
        }


        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                int down = dp[i-1][j] + Math.abs(arr[i][j] - arr[i-1][j]);
                int right = dp[i][j-1] + Math.abs(arr[i][j] - arr[i][j-1]);
                dp[i][j] = Math.min(down, right);
            }
        }

        System.out.println(dp[n-1][m-1]);

    }
}
