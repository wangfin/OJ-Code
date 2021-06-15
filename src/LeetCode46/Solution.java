package LeetCode46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 采用回溯法
     * 类似于一个决策树，在树的每一个节点做决策，然后有一个数组（path）记录路径，也就是记录每一个决策
     * 决策可以回溯，重新从决策候选中选
     *
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        // 数组中已经使用过的数字
        boolean[] used = new boolean[len];
        // 路径列表，保存遍历的排列
        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        int len = nums.length;
        // 叶子节点，也就是终止条件，nums数组中的元素个数=树的深度
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            // 如果元素没有被使用
            if (!used[i]) {
                // path添加这个路径
                path.add(nums[i]);
                // 设置为已经使用
                used[i] = true;

                dfs(nums, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
