package tianyiyun;
import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] waters = new int[]{1, 5, 10, 20, 50, 100};

        if (n == 0){
            System.out.println(0);
        }else{
            // 设置数组dp，dp表示i的水有多少种组合方式
            int dp[] = new int[n + 1];
            // dp[0] = 0
            dp[0] = 1;

            // 遍历所有的面值
            for (int water: waters){
                // 从coin这个值到amount，遍历里面每一个值，也就是i值
                for (int i = water; i <= n; i++){
                    // 数值为i的组合数也就是，i-coin的组合数，因为i就是i-coin + coin，组合数不变
                    dp[i] += dp[i - water];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
