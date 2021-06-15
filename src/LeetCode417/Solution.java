package LeetCode417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
     * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
     * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
     * 提示：
     *   输出坐标的顺序不重要
     *   m 和 n 都小于150
     *
     * 给定下面的 5x5 矩阵:
     *
     *   太平洋 ~   ~   ~   ~   ~
     *        ~  1   2   2   3  (5) *
     *        ~  3   2   3  (4) (4) *
     *        ~  2   4  (5)  3   1  *
     *        ~ (6) (7)  1   4   5  *
     *        ~ (5)  1   1   2   4  *
     *           *   *   *   *   * 大西洋
     *
     * 返回:
     * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
     *
     * 遍历每一个点，只要一个点左上、右下满足，那么这个点就能够满足条件
     *
     */

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for (int i = 0 ; i < heights.length; i ++){
            for (int j = 0; j < heights[0].length; j++){
                if (dfs(heights, i, j)){
                    int[] pos = new int[]{i, j};
                    
                    // res.add(pos);
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] heights, int cur_i, int cur_j){
        return true;
    }
}
