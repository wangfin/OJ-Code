package xiaohongshu;

import java.util.Scanner;

public class Solution1_1 {
    public static void main(String[] args) {
        // 深度优先遍历
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] scores = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                scores[i][j] = sc.nextInt();
            }
        }
        // int[] ans = new int[4];
        int[] b = new int[N];
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int bestr1 = 0, bestc1 = 0;
        for (int i = 0; i < N; i++){
            for (int t = 0; t < N; t++){
                b[t] = 0;
            }
            for (int j = i; j < N; j++){
                sum = 0;
                for (int k = 0; k < N; k++){
                    b[k] += scores[j][k];
                    if (sum > 0){
                        sum += b[k];
                    }else{
                        sum = b[k];
                        bestr1 = i;
                        bestc1 = k;
                    }
                    if (sum > max_sum){
                        max_sum = sum;
//                        ans[0] = bestr1;
//                        ans[1] = bestc1;
//                        ans[2] = j;
//                        ans[3] = k;
                    }
                }
            }
        }
        System.out.println(max_sum);
    }
}
