package LeetCode674;

import java.util.Arrays;

public class Solution {
    /**
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
     * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     *
     * 本题与LeetCode300的区别在于，这个是连续的
     *
     * 动态规划
     * dp[i]：以下标i为结尾的数组的连续递增的子序列长度为dp[i]。
     * 递推公式：
     * 如果 nums[i + 1] > nums[i]，那么以 i+1 为结尾的数组的连续递增的子序列长度 一定等于 以i为结尾的数组的连续递增的子序列长度 + 1 。
     * 即：dp[i + 1] = dp[i] + 1;
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 全部初始化为1
        Arrays.fill(dp, 1);
        // 返回结果
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i + 1] > nums[i]) {
                // 转移
                dp[i + 1] = dp[i] + 1;
            }
            res = res > dp[i + 1] ? res : dp[i + 1];
        }
        return res;
    }
}
