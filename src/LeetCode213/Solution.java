package LeetCode213;

public class Solution {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     *
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 这道题的思路应该还是dp，主要多了一个第一和最后一个是相邻的这个条件
     *
     * 本题在传统的198打家劫舍上加入了环形条件
     *
     * 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题：
     *
     * 1. 在不偷窃第一个房子的情况下（即 nums[1:]nums[1:]），最大金额是 p_1p；
     * 2. 在不偷窃最后一个房子的情况下（即 nums[:n-1]nums[:n−1]），最大金额是 p_2p。
     * 综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)max(p1,p2) 。
     */
    public int rob(int[] nums) {
        // 没有元素和只有一个元素的情况
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // 0 - nums.length-1，从0到结尾-1
        int rob_first = rob_line(nums, 0, nums.length-1);
        // 1 - nums.length，从1到结尾
        int rob_last = rob_line(nums, 1, nums.length);

        return Math.max(rob_first, rob_last);
    }

    public int rob_line(int[] nums, int start, int end) {
        // dp
        int[] dp = new int[end];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        // 取max(dp[i-1], dp[i-2] + nums[i])
        for (int i = start+2; i < end; i ++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[end - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,9,2};
        int res = new Solution().rob(nums);
        System.out.println(res);
    }
}
