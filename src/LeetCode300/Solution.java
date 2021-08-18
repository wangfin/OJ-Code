package LeetCode300;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * 动态规划
     * 状态定义：dp[i] 的值代表 nums 前 i 个数字的最长子序列长度，注意 nums[i] 必须被选取。
     * 转移方程： 设 j∈[0,i)，考虑每轮计算新 dp[i] 时，遍历 [0,i) 列表区间，做以下判断：
     *   -当 nums[i] > nums[j] 时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1；
     *   -当 nums[i] <= nums[j] 时： nums[i] 无法接在 nums[j] 之后，此情况上升子序列不成立，跳过。
     * 上述所有 1. 情况 下计算出的 dp[j] + 1 的最大值，为直到 i 的最长上升子序列长度（即 dp[i] ）。
     * 实现方式为遍历 j 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)。
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     * 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值
     * 初始状态：dp[i] 所有元素置 11，含义是每个元素都至少可以单独成为子序列，此时长度都为 11。
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        // dp[i] 的值代表 nums 前 i 个数字的最长子序列长度
        int[] dp = new int[nums.length + 1];
        int res = 0;
        // 全部初始化为1，即每一个可以单独成为一个序列
        Arrays.fill(dp, 1);
        // 开始遍历
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                // 只有nums[i]>nums[j]才能继续上升
                if(nums[j] < nums[i])
                    // 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
