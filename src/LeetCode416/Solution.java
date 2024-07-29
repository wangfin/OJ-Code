package LeetCode416;

import java.util.Arrays;

/**
 * @Author wangfin
 * @Date 2024/7/23
 * @Desc 416. 分割等和子集
 */
public class Solution {

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 示例 1：
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * 示例 2：
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     */

    /**
     * 本题一开始想到的是回溯，即反复遍历尝试，但这里提到了使用动态规划的方式，所以使用动规
     * 动规是一个01背包，即数组中的子集只能使用一次
     * 动规的dp数组设置为 dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]
     * 当dp[j]=j是，表示背包装满了
     * 当dp[j]=sum(nums)/2时，表示有这样两个子集
     */

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;

        int target = sum / 2;

        int[] dp = new int[target + 1];
        dp[0] = 0;

        // 外层遍历物品
        for (int i = 0; i < nums.length; i++) {
            // 内层遍历背包
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        boolean res = new Solution().canPartition(nums);
        System.out.println(res);

    }
}
