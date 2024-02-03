package LeetCode78;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangfin
 * @Date 2024/1/21
 * @Desc 子集
 */
public class Solution2 {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Stack<Integer> path = new Stack<>();

        // 不能选重复的，所以还是使用startIndex
        int startIndex = 0;

        // 子集就是每种长度的 全排列（顺序无关，只要保证有就行）
        // 也就是长度=1 的排列，长度等于2的排列，是LeetCode77的升级版
        // 其实这道题遍历的中间过程就是结果集，所以不需要设置返回条件才加入到结果，直接全部加入即可
        backtracking(startIndex, nums, path, res);

        return res;
    }

    void backtracking(int startIndex, int[] nums, Stack<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i ++) {
            path.push(nums[i]);
            backtracking(i + 1, nums, path, res);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Solution2().subsets(nums);
        System.out.println(res);
    }
}
