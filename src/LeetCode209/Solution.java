package LeetCode209;

public class Solution {
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
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 初始化一个最大值
        int min = Integer.MAX_VALUE;
        // 双重for循环
        for (int i = 0; i < nums.length; i ++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                // 满足条件
                if (sum >= target){
                    // 取得最小值
                    min = Math.min(min, j-i+1);
                    // 跳出循环
                    break;
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int target = 11;
        int min = new Solution().minSubArrayLen(target, nums);
        System.out.println(min);
    }

}
