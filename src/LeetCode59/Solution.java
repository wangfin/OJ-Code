package LeetCode59;

import java.util.Arrays;

public class Solution {
    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     *
     * 就是顺时针排序的正方形矩阵，简单方法可以模拟这个过程
     * 四个方向，上下左右，设置边界，above，below，left，right
     *  生成一个 n×n 空矩阵 mat，随后模拟整个向内环绕的填入过程：
     *  定义当前左右上下边界 l,r,t,b，初始值 num = 1，迭代终止值 tar = n * n；
     *  当 num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
     *      执行 num += 1：得到下一个需要填入的数字；
     *      更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
     *  使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
     * 最终返回 mat 即可。
     *
     */
    public int[][] generateMatrix(int n) {
        // 创建输出矩阵
        int[][] mat = new int[n][n];
        // 设置边界
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1, tar = n * n;
        while (num <= tar){
            // 从左往右
            for (int i = l; i <= r; i++){
                mat[t][i] = num ++;
            }
            // 上边界向下
            t ++;
            // 从上往下
            for (int i = t; i <= b; i++){
                mat[i][r] = num ++;
            }
            // 右边界向左
            r --;
            // 从右往左
            for (int i = r; i >= l; i--){
                mat[b][i] = num ++;
            }
            // 下边界向上
            b --;
            // 从下往上
            for (int i = b; i >= t; i--){
                mat[i][l] = num ++;
            }
            // 左边界向右
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] res = new Solution().generateMatrix(n);
        System.out.println(Arrays.deepToString(res));
    }


}
