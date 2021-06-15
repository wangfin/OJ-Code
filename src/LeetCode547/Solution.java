package LeetCode547;

public class Solution {
    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     *
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     *
     * 返回矩阵中 省份 的数量。
     *
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     *
     * 深度搜索
     * 递归写法
     *
     */
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        // 是否访问过节点的列表
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i ++){
            if (!visited[i]){
                dfs(isConnected, i, visited);
                count ++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited){
        // 该节点置为已经访问
        visited[i] = true;
        for (int k = 0; k < isConnected.length; k ++){
            // 把每个相连的都访问一遍，这样就找到了一个全部相连的环
            if (isConnected[i][k] == 1 && !visited[k]){
                dfs(isConnected, k, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        int res = new Solution().findCircleNum(isConnected);
        System.out.println(res);
    }
}
