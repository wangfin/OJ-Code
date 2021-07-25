package LeetCode53;

public class Solution {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 简单思路就是暴力，两个for循环
     *
     * 动态规划
     *
     * 将求n个数的数组的最大子段和，转换为分别求出以第1个，第2个...第i个，...，第n个数字结尾的最大子段和
     * 注意是以第i个数字结尾的最大子段和
     * 以这种方式，dp[i]才能和dp[i-1]联系起来
     *
     * 具体为，以第i个数字结尾的最大子段和，其实就是第i-1个最大子段和+第i个值是否大于第i个值
     * 如果大于，那么很明显以第i个数字结尾的最大子段和就是第i-1+第i个值
     * 如果小于，那就是第i个值自己单独成为一段
     */
    public int maxSubArray(int[] nums) {
        // 边界情况
        if(nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        // 初始值
        dp[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i ++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);

            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }
}
