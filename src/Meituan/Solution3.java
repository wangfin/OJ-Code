package Meituan;

import java.util.Scanner;

public class Solution3 {
    /**
     * 小美数学很好，小团数学不怎么好。
     * 有一天小美又在用数学题欺负小团，她提出了这样一个问题：
     * “有多少个长度为n的仅由a和b组成的字符串既不包含aba也不包含bab？
     * 如果你算不来大数你可以告诉我这个问题的答案模上998244353是多少”小团实在忍不住了，所以他决定来找你帮忙。
     * 输入描述
     * 第一行有一个整数n(1<=n<=100000)，代表小美问题中的参数。
     *
     * 输出描述
     * 输出一个整数，即小美所问问题的答案除以998244353所得余数。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        // dp[i]表示到第i个字符有多少种组成方式
        int[] dp = new int[n + 1];
        if (n <= 3){
            System.out.println((int)Math.pow(2, n-1) + 2);
        }else {
            dp[1] = 0;
            dp[2] = 0;
            dp[3] = 2;
            for (int i = 4; i <= n; i++){
                dp[i] = (int)Math.pow(2, i) - (dp[i-1] + dp[i-2] + 2*dp[i-1]);
            }
            System.out.println(dp[n] % 998244353);
        }
    }
}
