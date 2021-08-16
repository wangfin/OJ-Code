package LeetCode724;

import java.util.Arrays;

public class Solution {
    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     *
     * 示例：
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     *
     * 前缀和
     * 记数组的全部元素之和为 total，当遍历到第 i 个元素时，设其左侧元素之和为 sum，则其右侧元素之和为 total−numsi−sum。
     * 左右侧元素相等即为 sum=total−numsi−sum，即 2×sum+numsi=total。
     *
     */
    public int pivotIndex(int[] nums) {
        // 求和
        int total = Arrays.stream(nums).sum();
        int sum = 0;

        // 开始遍历
        for (int i = 0; i < nums.length; ++i) {
            // 左右元素相等的时候
            if (2 * sum + nums[i] == total) {
                return i;
            }
            // 左边的元素
            sum += nums[i];
        }
        return -1;
    }


}
