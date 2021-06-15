package LeetCode695;

public class Solution2 {
    /**
     * 递归写法，深度优先搜索
     * 一般来说，深度优先搜索类型的题可以分为主函数和辅函数
     * 主函数用于遍历所有的搜索位置，判断是否可以开始搜索，如果可以即在辅函数进行搜索。
     * 辅函数则负责深度优先搜索的递归调用。
     *
     * 在辅函数里，一个一定要注意的点是辅函数内递归搜索时，边界条件的判定。
     * 边界判定一般有两种写法：
     * 一种是先判定是否越界，只有在合法的情况下才进行下一步搜索（即判断放在调用递归函数前）；
     * 另一种是不管三七二十一先进行下一步搜索，待下一步搜索开始时再判断是否合法（即判断放在辅函数第一行）。
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        // 遍历
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                // 找到开始搜索的位置，也就是土地
                if (grid[i][j] == 1){
                    // 调用辅函数进行搜索
                    max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        return max_area;
    }

    public int dfs(int[][] grid, int cur_i, int cur_j){
        // 递归，不是土地就返回0
        if (grid[cur_i][cur_j] == 0)
            return 0;
        // 将当前值置为0
        grid[cur_i][cur_j] = 0;
        // 土地的大小为1
        int area = 1;
        // 四个方向
        int[] direction = new int[]{-1, 0, 1, 0, -1};
        // 向四个方向进行搜索
        for (int i = 0; i < 4; i ++){
            int x = cur_i + direction[i];
            int y = cur_j + direction[i+1];
            // 边界条件，并且这个位置也是土地
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                // +1+1，递归调用，找到一片完整的区域
                area += dfs(grid, x, y);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1},{1,1}};
        int result = new Solution2().maxAreaOfIsland(grid);
        System.out.println(result);
    }
}
