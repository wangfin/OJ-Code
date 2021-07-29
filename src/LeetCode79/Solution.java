package LeetCode79;

public class Solution {
    /**
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     *
     * 该题与剑指Offer12相同，是矩阵搜索，也就是深度优先遍历+回溯
     * 直接抄题解了
     *
     */
    public boolean exist(char[][] board, String word) {
        // 获取board矩阵的长宽
        int h = board.length, w = board[0].length;
        // 设置矩阵标志是否访问过，其实直接将board中的元素置为0，这样也可以达到相同的效果，而且也能少使用额外空间
        boolean[][] visited = new boolean[h][w];
        // 遍历
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // dfs函数，用来搜索
                // k 表示word中已经被找到的字符位置
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        // 结束条件
        // 如果字符不相等就直接结束
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {// 全部符合，说明找到这个字符串了
            return true;
        }
        // 找到匹配的字符了，那就设置为已访问
        visited[i][j] = true;
        // 方向数组，右，左，下，上
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            // 边界探索
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 如果没有被访问，防止重复访问
                if (!visited[newi][newj]) {
                    // 继续往下面探索
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    // 成功还是不成功，也就是上面的结束条件的返回值
                    if (flag) {
                        // 结果成功，可以结束
                        result = true;
                        break;
                    }
                }
            }
        }
        // 重置，为下一次搜索
        visited[i][j] = false;
        return result;
    }
}
