package LeetCode216;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangfin
 * @Date 2024/2/26
 * @Desc 组合总和 III
 */
public class Solution {

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * <p>
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     * <p>
     * 示例 1:
     * <p>
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 解释:
     * 1 + 2 + 4 = 7
     * 没有其他符合的组合了。
     * 示例 2:
     * <p>
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * 解释:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * 没有其他符合的组合了。
     * <p>
     * 示例 3:
     * 输入: k = 4, n = 1
     * 输出: []
     * 解释: 不存在有效的组合。
     * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
     */

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        int startIndex = 1;
        Stack<Integer> path = new Stack<>();
        int sum = 0;

        backtracking(n, k, startIndex, sum, path, res);

        return res;
    }

    public void backtracking(int n, int k, int startIndex, int sum, Stack<Integer> path, List<List<Integer>> res) {
        if (sum > n) {
            return;
        }

        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        // todo <= 9这里可以做一个剪枝操作
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.push(i);
            sum += i;
            backtracking(n, k, i + 1, sum, path, res);
            sum -= i;
            path.pop();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> res = new Solution().combinationSum3(k, n);
        System.out.println(res.toString());
    }
}
