package LeetCode53;

public class Solution1 {
    /**
     * 贪心算法
     * 局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
     * 全局最优：选取最大“连续和”
     * 局部最优的情况下，并记录最大的“连续和”，可以推出全局最优。
     */
    public int maxSubArray(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            // 计算局部的最大和
            count += nums[i];
            // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            sum = Math.max(sum, count);
            if (count <= 0){
                // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
                count = 0;
            }
        }
        return sum;
    }
}
