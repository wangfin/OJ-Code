package LeetCode740;

public class Solution {
    /**
     * 给你一个整数数组nums，你可以对它进行一些操作。
     * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     *
     * 输入：nums = [3,4,2]
     * 输出：6
     * 解释：
     * 删除 4 获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
     *
     * 这是一个跟198打家劫舍类似的题目，就是每个位置上的数字是可以在两种前结果之上进行选择的：
     * 1.如果你不删除当前位置的数字，那么你得到就是前一个数字的位置的最优结果。
     * 2.如果你觉得当前的位置数字i需要被删，那么你就会得到i - 2位置的那个最优结果加上当前位置的数字乘以个数。
     * 所以这个需要先统计每个数字的个数，如果选择这个位置的数字，那么数字前后的数字都要删除
     *
     */
    public int deleteAndEarn(int[] nums) {
        // 判断边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int max = nums[0];
        // 找到nums数组中的最大值
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
        // 构造一个新的数组all，all是用来保存每个数字的频次的
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item] ++;
        }
        // 构建dp
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        // 动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,3,3,4};
        int res = new Solution().deleteAndEarn(nums);
        System.out.println(res);
    }

}
