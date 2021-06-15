package LeetCode70;

public class Solution {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 动态规划
     */

    public int climbStairs(int n) {
        // n阶台阶
        // 第i阶台阶的方式=第i-1阶+第i-2阶的方式
        if(n <= 1)
            return n;
        // 先创建一个数组来保存历史数据
        int[] dp = new int[n+1];
        // 给出初始值
        dp[0] = 0;
        dp[1] = 1;
        // 通过关系式来计算出do[n]
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 返回结果
        return dp[n];

    }
}
