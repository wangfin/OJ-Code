package LeetCode46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangfin
 * @Date 2024/1/6
 * @Desc 全排列
 */
public class Solution2 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     * 排列组合问题 回溯算法
     */
    public List<List<Integer>> permute(int[] nums) {
        // 返回结果
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(Arrays.asList(nums[0]));
            return res;
        }

        Stack<Integer> path = new Stack<>();
        // 全排列与组合区别在于，不是使用startIndex来决定取的值，因为组合是有顺序的
        // 而排列需要构建一个已经使用的列表，记录哪些被使用了
        boolean[] used = new boolean[nums.length];

        // 回溯就是构建一个决策树，纵向是总的深度，横向是当前可选的所有分支
        backtracking(used, nums, path, res);

        return res;
    }

    void backtracking(boolean[] used, int[] nums, Stack<Integer> path, List<List<Integer>> res) {
        // 退出递归的条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.push(nums[i]);
            backtracking(used, nums, path, res);
            path.pop();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Solution2().permute(nums);
        System.out.println(res.toString());
    }
}
