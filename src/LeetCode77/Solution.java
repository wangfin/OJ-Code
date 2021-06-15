package LeetCode77;

import java.util.*;

public class Solution {
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
        // 返回结果
        List<List<Integer>> res = new ArrayList<>();
        // 符合条件的结果，这里用的stack
        Stack<Integer> path = new Stack<>();
        if (k <= 0 || n < k) {
            return res;
        }

        // startIndex用于控制搜索的起始位置
        int startIndex = 1;
        backtracking(n, k, startIndex, path, res);
        return res;

    }

    public void backtracking(int n, int k, int startIndex, Stack<Integer> path, List<List<Integer>> res){
        // 终止条件
        if (path.size() == k){
            // 把当前结果保存在res中
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历本层
        for (int i = startIndex; i <= n; i ++){
            // 将待遍历的元素压入path中
            path.push(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            backtracking(n, k, i+1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            // 回溯，撤销处理的节点
            // stack后进先出
            path.pop();
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = new Solution().combine(n, k);
        System.out.println(res.toString());
    }
}
