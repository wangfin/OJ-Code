package LeetCode240;

public class Solution1 {
    /**
     * 这道题看到一个其他的巧妙解法
     * 也就是，如果从右上角开始遍历
     * 当前节点「大于」目标值，搜索当前节点的「左子树」，也就是当前矩阵位置的「左方格子」，即 c--
     * 当前节点「小于」目标值，搜索当前节点的「右子树」，也就是当前矩阵位置的「下方格子」，即 r++
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 行
        int r = 0;
        // 列
        int c = n - 1;
        while (r < m && c >= 0){
            if (matrix[r][c] == target)
                return true;
            else if(matrix[r][c] > target)
                // 列向左移动
                c --;
            else if (matrix[r][c] < target){
                // 行向下
                r ++;
            }
        }
        return false;
    }

}
