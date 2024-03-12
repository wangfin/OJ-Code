package LeetCode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/3/12
 * @Desc 组合总和 II
 */
public class Solution {
    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 注意：解集不能包含重复的组合。
     * <p>
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     */

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 对输入数组排序，为了后面取的时候可以进行剪枝
        // 正序
        Arrays.sort(candidates);

        // 本题的难点在于解集不能包含重复的组合
        // 这个主要是需要在横向遍历的时候，如果上一个元素与当前元素相同，且上一个元素已经使用过，那么当前元素就不能使用
        int startIndex = 0;
        int sum = 0;
        boolean[] used = new boolean[candidates.length];
        backTracking(candidates, target, startIndex, used, sum);

        return res;
    }

    public void backTracking(int[] candidates, int target, int startIndex, boolean[] used, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 因为不能出现重复的解集
        for (int i = startIndex; i < candidates.length; i++) {

            if (sum+candidates[i] > target) {
                break;
            }

            // 需要过滤到同一数层取得值，所以used[i-1]其实不能被使用过，被使用过代表是同一个树枝上面的
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, i + 1, used, sum);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;
        List<List<Integer>> res = new Solution().combinationSum2(candidates, target);
        System.out.println(res.toString());
    }
}
