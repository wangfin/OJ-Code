package LeetCode74;

public class Solution {
    /**
     * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 从上到下，从左到右，都是升序序列
     * 所以先对第一列做二分查找，然后找到列之后对行在做二分查找
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // m * n
        int m = matrix.length, n = matrix[0].length;
        int begin = 0;
        int end = m * n - 1;

        while (begin <= end){
            int mid = (begin + end) / 2;
            // 找到这个值
            int num = matrix[mid/n][mid%n];
            if (target == num){
                return true;
            }else if(target < num){// 左区间
                end = mid - 1;
            }else{// target > num 右区间
                begin = mid + 1;
            }
        }
        return false;

    }
}
