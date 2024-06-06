package LeetCode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/5/8
 * @Desc 全排列 II
 */
class Solution {

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * 示例 1：
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        // 需要自己手动排序一下，不然used无法前后使用
        Arrays.sort(nums);
        backtracking(used, nums);
        return res;
    }

    void backtracking(boolean[] used, int[] nums) {
        // 终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 循环遍历
        for (int i = 0; i < nums.length; i++) {
            // 如果上一个元素被使用过，则跳过，反之则加入
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtracking(used, nums);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(nums));
    }


}
