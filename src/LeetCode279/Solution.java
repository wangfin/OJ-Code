package LeetCode279;

public class Solution {
    /**
     * 完全平方数
     * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     * 简单想法肯定是循环，从1-根号n，遍历
     * 然后看到题解，动态规划，哦，题目没看清，是要个数最小
     * 设置dp为数字为i的最小的完全平方数的个数，dp[i] = MIN(dp[i], dp[i - j * j] + 1)
     * 这里的dp[i] = i，表示，是有多少个1组成
     * +1是表示加上一个j*j，j的范围就是i-j*j>=0
     * 需要将全部dp设置为0
     */
    public int numSquares(int n) {// 初始化为0
        int[] dp = new int[n + 1];
        // 因为这个i得从1开始，是具有实际意义的
        for (int i = 1; i <= n; i++){
            // 最坏的情况就是每次+1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
        
    }

    public static void main(String[] args) {
        int n = 12;
        int res = new Solution().numSquares(n);
        System.out.println(res);
    }
}
