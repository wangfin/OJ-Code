package Huawei;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        int[] t = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++){
            v[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            t[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            d[i] = sc.nextInt();
        }

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++){
            arr[i][0] = v[i];
            arr[i][1] = t[i];
            arr[i][2] = d[i];
        }

//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]){
//                    return o1[0] - o2[0];
//                }
//                return o2[0] - o1[0];
//            }
//        });
        Arrays.sort(d);

        int max = d[n-1];
        int res = 0;
        int[] dp = new int[max+1];
        for (int i = 0; i < n; i++){
            for (int j = arr[i][2]; j >= arr[i][1]; j--){
                dp[j] = Math.max(dp[j], dp[j-arr[i][1]] + arr[i][0]);
                if (dp[j] > res){
                    res = dp[j];
                }
            }
        }
        System.out.println(res);

//        int tt = 0;
//        int[] dp = new int[n+1];
//        // 贪心
//        for (int i = 1; i <= n; i++){
//            int tmp = tt + arr[i-1][1];
//            if (tmp <= arr[i-1][2]){
//                if (dp[i] + arr[i-1][0] >= dp[i-1]){
//                    tt += arr[i-1][1];
//                    dp[i] = dp[i]+arr[i-1][0];
//                }else{
//                    dp[i] = dp[i-1];
//                }
//            }else{
//                dp[i] = dp[i-1];
//            }
//        }
//
//        System.out.println(dp[n]);
    }
}
