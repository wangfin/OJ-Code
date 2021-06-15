package LeetCode867;

class Solution {
    /**
     * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
     *
     * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     */

    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        // matrix = [[1,2,3],[4,5,6],[7,8,9]]
        // matrix.length 是行数，matrix[0].length 是列数
        // 交换行和列，也就是交换x和y
        for(int i = 0 ; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                // int tmp = matrix[i][j];
                // matrix[i][j] = matrix[j][i];
                // matrix[j][i] = tmp;
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6}};

        System.out.println((new Solution()).transpose(matrix));
    }
}
