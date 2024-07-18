package LeetCode746;

/**
 * @Author wangfin
 * @Date 2024/7/11
 * @Desc 746 使用最小花费爬楼梯
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {

        // dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]
        // 这里将初始化设置为0，表示前两个台阶不需要花费体力，即你原来就站在这个台阶上
        // 到达dp[i]有两个途径，一个是dp[i-1] 一个是dp[i-2]
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i ++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{10,15,20};
        int res = new Solution().minCostClimbingStairs(cost);
        System.out.println(res);
    }
}
