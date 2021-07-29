package Offer12;

public class Solution {
    /**
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     *
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * 矩阵搜索，深度优先遍历（DFS）
     * 参考题解，加入了剪枝
     *
     * 递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     * 终止条件：
     *  1.返回 false ： (1) 行或列索引越界 或 (2) 当前矩阵元素与目标字符不同 或 (3) 当前矩阵元素已访问过 （ (3) 可合并至 (2) ） 。
     *  2.返回 true ： k = len(word) - 1 ，即字符串 word 已全部匹配。
     * 递推工作：
     *  1.标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问。
     *  2.搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，
     *  使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
     *  3.还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
     * 返回值： 返回布尔量 res ，代表是否搜索到目标字符串。
     *
     */
    public boolean exist(char[][] board, String word) {
        // toCharArray() 方法将字符串转换为字符数组
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j ++){
                //递归，k是当前识别到的字符的位置
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k){
        // 边界条件，i，j的边界，和矩阵的中的字符不是word中的字符
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        // 如果全部识别完，也就是k=word.length -1
        if (k == word.length - 1)
            return true;
        // 上面两个是终止条件
        // 这个是将已经识别过的字符置0，防止再次识别
        board[i][j] = '\0';
        // 四个方向探索，只要有一个方向匹配即可，所以用或
        // 这里用的四个递归，其实可以用方向数组和循环来实现
        // 方向数组 direction{-1, 0, 1, 0, -1} x = x + direction[i], y = y + direction[i+1];
        boolean res = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1)
                || dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);

        // 最后恢复，应该为了方便下一次的搜索过程
        board[i][j] = word[k];
        return res;
    }


}
