package LeetCode209;

public class Solution1 {
    /**
     *
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
     * 如果不存在符合条件的子数组，返回 0 。
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 简单想法：
     * 肯定还是双重for循环，从每个元素开始遍历，找到满足的最短子数组（牛的，简单方法可以过）
     * 改进想法：
     * 滑动窗口，但是这个窗口的大小是不固定的，应该算是双指针
     * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组
     * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）
     * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了
     *
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++){
            sum += nums[right];
            // 如果子数组的sum大于target，就查看这个子数组的长度
            // 取最小值
            while (sum >= target){
                result = Math.min(result, right - left + 1);
                // 看看左指针能不能往右移，缩短子数组的长度
                sum = sum - nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
