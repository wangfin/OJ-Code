package LeetCode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/3/4
 * @Desc 组合总和
 */
public class Solution {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * 输入: candidates = [2], target = 1
     * 输出: []
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 也是一个树结构，然后遍历candidates去取值，不过这个是不限制次数的，然后求和

        // 因为无法保证给的candidates是排序好的，所以可以先排序，保证是从小的开始加
        // 当tempValue > target时，后面的数据也不需要遍历了，这就是剪枝
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int tempValue = 0;
        int startIndex = 0;
        backTracking(candidates, target, tempValue, startIndex, path, res);

        return res;

    }

    public void backTracking(int[] candidates, int target, int tempValue, int startIndex, List<Integer> path, List<List<Integer>> res) {
        if (tempValue == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (tempValue + candidates[i] > target) {
                break;
            }
            tempValue += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, tempValue, i, path, res);
            path.remove(path.size() - 1);
            tempValue -= candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new Solution().combinationSum(candidates, target);
        System.out.println(res.toString());

    }
}
