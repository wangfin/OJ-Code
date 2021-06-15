package LeetCode695;

import java.util.Stack;

public class Solution1 {
    /**
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     *
     * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
     * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     *
     * 示例：
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     *
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     *
     * 使用循环+栈（stack）实现深度优先搜索（没有使用递归调用）
     * 访问每一片土地时，我们将对围绕它四个方向进行探索，找到还未访问的土地，加入到栈 stack 中；
     * 另外，只要栈 stack 不为空，就说明我们还有土地待访问，那么就从栈中取出一个元素并访问。
     *
     */
    public int maxAreaOfIsland(int[][] grid) {
        // 四个方向，每相邻两位即为上下左右四个方向之一
        // (-1,0)上 (0,1)右 (1,0)下 (0,-1)左
        int[] direction = {-1, 0, 1, 0 ,-1};
        // 长宽
        int m = grid.length;int n = grid[0].length;
        // 当前土地的总大小
        int local_area;
        // 面积
        int area = 0;
        int x,y;
        // 遍历地图
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                // 是土地
                if (grid[i][j] == 1){
                    // 第一块土地，local_area置1
                    local_area = 1;
                    // 遍历过的土地置为0，防止重复计算
                    grid[i][j] = 0;
                    // 两个Stack，一个用来存i，一个存j
                    Stack<Integer> islandi = new Stack<Integer>();
                    Stack<Integer> islandj = new Stack<Integer>();
                    // 将当前的i，j压入Stack
                    islandi.push(i);
                    islandj.push(j);
                    // 如果Stack不为空，意味着还有需要遍历的土地
                    while (!islandi.empty() && !islandj.empty()){
                        int cur_i = islandi.pop(), cur_j = islandj.pop();
                        // 四个方向
                        for (int k = 0; k < 4; k ++){
                            x = cur_i + direction[k];
                            y = cur_j + direction[k+1];
                            // 边界条件，并且这个位置也是土地
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                                // 置0
                                grid[x][y] = 0;
                                // 这个岛屿的面积++
                                local_area++;
                                // 再把x,y压入
                                islandi.push(x);
                                islandj.push(y);
                            }
                        }
                    }
                    // 选出最大的那个岛屿的面积
                    area = Math.max(area, local_area);
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{1,1}};
        int result = new Solution1().maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
