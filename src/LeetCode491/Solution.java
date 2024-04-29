package LeetCode491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/4/29
 * @Desc 非递减子序列
 */
public class Solution {

    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * 示例 1：
     * 输入：nums = [4,6,7,7]
     * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
     * 示例 2：
     * 输入：nums = [4,4,3,2,1]
     * 输出：[[4,4]]
     */

    /**
     * 递增，还需要子序列，重复的没有关系
     */

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 1) {
            return res;
        }

        backTracing(nums, 0);

        return res;
    }

    private void backTracing(int[] nums, int startIndex) {
        // 停止条件
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }

        HashSet<Integer> hashSet = new HashSet<>();
        // 循环遍历
        for (int i = startIndex; i < nums.length; i++) {

            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || hashSet.contains(nums[i])) {
                continue;
            }

            hashSet.add(nums[i]);
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.findSubsequences(nums);
        System.out.println(res);
    }
}
