package LeetCode518;

public class Solution {
    /**
     *
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * 这个要给出的是所有的组合方式，零钱兑换I是最少的硬币个数，这个是所有的组合方式
     *
     * 动态规划
     * 1.初始化 dp[0]=1；
     * 2.遍历 coins，对于其中的每个元素 coin，进行如下操作：
     *   2.1遍历 i 从 coin 到 amount，将 dp[i−coin] 的值加到 dp[i]。
     * 3.最终得到 dp[amount] 的值即为答案。
     *
     */
    public int change(int amount, int[] coins) {
        // 设置数组dp，dp表示i的金额有多少种硬币组合方式
        int dp[] = new int[amount + 1];
        // 0块钱不用选取硬币，所以只有一种方式
        dp[0] = 1;
        // 遍历所有的硬币面值
        for (int coin: coins){
            // 从coin这个值到amount，遍历里面每一个值，也就是i值
            for (int i = coin; i <= amount; i++){
                // 数值为i的组合数也就是，i-coin的组合数，因为i就是i-coin + coin，组合数不变
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];

    }
}
