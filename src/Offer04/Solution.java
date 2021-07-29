package Offer04;

public class Solution {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 一般这种可以用二分法
     * 然后先用提出的一种巧妙办法，就是缩小搜索空间，从左下角或者右上角开始（说是变成二叉搜索树）
     * 因为右上角和左下角都是一边增大，一边减小的，这样可以进行缩减
     *
     * “根节点” 对应的是矩阵的 “左下角” 和 “右上角” 元素，本文称之为 标志数 ，以 matrix 中的 左下角元素 为标志数 flag ，则有:
     * 若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去。
     * 若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去。
     *
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 使用左下角
        int i = matrix.length - 1;int j = 0;
        // i--;j++
        while (i >= 0 && j < matrix[0].length ){
            // 找到了
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] < target){
                j++;
            }else if (matrix[i][j] > target){
                i--;
            }
        }
        return false;
    }
}
