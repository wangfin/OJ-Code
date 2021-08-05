package Shopee03;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * 数的划分
     * 将整数n分成k份，且每份不能为空，任意两种分法不能相同(不考虑顺序)。
     * 例如: n = 7, k = 3, 下面三种分法被认为是相同的：
     * 1, 1, 5; 1, 5, 1; 5, 1, 1。
     * 问有多少种不同的分法。
     * 输入: n, k (6 < n < 200, 1 < k < 7)
     * 输出: 一个整数 (所有可能的分法总数)
     *
     * @param n int整型 整数n
     * @param k int整型 分为k份
     * @return int整型
     */

    public int divide(int n, int k) {
        // dp[i][j]表示数字i分成j份总共有多少种分法
        int[][] dp = new int[n+1][k+1];
        // 初值
        dp[0][0] = 1;
        // 开始遍历
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                //由于每份不能为空，所以划分数肯定大于总份数
                if(i >= j) {
                    //分为至少存在一份是1，和所有份数大于1两种情况
                    dp[i][j] = dp[i-1][j-1] + dp[i-j][j];
                }
            }
        }
        return dp[n][k];//返回结果
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int res = new Solution().divide(n, k);
        System.out.println(res);
    }
}
