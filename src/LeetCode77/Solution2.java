package LeetCode77;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/1/7
 * @Desc 组合
 */
public class Solution2 {

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     *
     * 回溯算法
     * 1.递归函数的返回值以及参数
     * 2.递归终止的条件
     * 3.每层搜索的过程
     */

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        int startIndex = 1;
        backtracking(n, k, startIndex, path, res);

        return res;
    }

    void backtracking(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> res) {
        // k为单个组合的长度，也就是遍历的深度
        if (path.size() >= k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i ++) {
            path.add(i);
            // 这边是因为取过的数不能继续取了，所以i要+1，不然直接从头开始即可
            backtracking(n, k, i + 1, path, res); // 递归
            // 这个整体是吧所有的叶子节点全部在一次遍历里面取出，所以这个path 会是 [1,2],[1,3],[1,4]
            // 也就是需要把最后一位去掉，然后换成别的值
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        List<List<Integer>> res = new Solution2().combine(n, k);
        System.out.println(res.toString());
    }

}
