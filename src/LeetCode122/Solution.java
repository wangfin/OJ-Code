package LeetCode122;

public class Solution {
    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 这是在1的基础上做的改进，可以多次买卖
     * 第一种还是贪心算法
     * 利润拆分
     * 假如第0天买入，第3天卖出，那么利润为：prices[3] - prices[0]。
     * 相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])。
     * 此时就是把利润分解为每天为单位的维度，而不是从0天到第3天整体去考虑！
     * 收集正利润的区间，就是股票买卖的区间，而我们只需要关注最终利润，不需要记录区间。
     * 局部最优：收集每天的正利润，全局最优：求得最大利润。
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int profit = 0;
        // 买入价格
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 当前利润就是后一天的价格减去前一天的价格
            profit = prices[i] - buy;
            // 如果利润是大于0的那就可以算成总得利润值了
            if (profit > 0) {
                sum += profit;
            }
            buy = prices[i];
        }
        return sum;
    }
}
