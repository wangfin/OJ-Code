package LeetCode322;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    /**
     *
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * 题解：
     * 钞票面值：coins=[1,2,5,7,10]
     * 设置dp[i]代表金额i的最优解，即最小使用的张数，数组dp[]中存储金额1至金额14的最优解
     * 金额i，也就是dp[i]可由：
     * 金额i-1与coins[0](1)组合，也就是+1
     * 金额i-2与coins[1](2)组合，+1
     * 依次类推
     * 最终是dp[i]= min(dp[i-1],dp[i-2],dp[i-5], dp[i-7],dp[i-10])+1
     */

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // 赋初始值为-1，表示没有面额可以凑出这个金额
        for(int i = 0; i < amount + 1; i ++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        // 计算每一个dp，dp里面是每一个金额的最小张数
        for(int i = 1; i <= amount; i ++){
            for(int j = 0; j < coins.length; j ++){
                // 当金额大于面额，并且dp[i-coins[j]]要有实际的张数
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }
        System.out.println(Arrays.toString(dp));
        // 判断是否为空，也就是面额无法组成金额
        if(dp[amount] <= amount)
            return dp[amount];
        else
            return -1;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] coins = {1};
        int amount = 0;
        int result = sol.coinChange(coins, amount);
        System.out.println(result);
    }
}


