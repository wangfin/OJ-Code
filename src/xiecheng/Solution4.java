package xiecheng;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i ++){
            times[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = 6;
        for (int i = 1; i < n; i++){
            if (times[i] - times[i-1] > 6){
                dp[i] = 6;
            }else{
                dp[i] = dp[i-1] + (6 - (times[i] - times[i-1]));
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (dp[i] > res){
                res = dp[i];
            }
        }

        System.out.println(res);

    }
}
