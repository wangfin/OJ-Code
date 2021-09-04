package xiaohongshu;

import java.util.Scanner;

public class Solution1 {
    /**
     * 小红书校园招聘，某个部门恰好招聘了N*N位（N<=150）同学，为了让大家快速融入大家庭，我们玩儿了一个快速记人和问题速答的游戏，
     * 开始是每个人的自我介绍，然后介绍自己的家乡特点和爱好，之后是问题提问，每个人会被问到多个关于另一个同学相关的问题，答对加一分，打错负一分，
     * 在所有问答环节结束之后，HR统计在这些同学中，哪个子矩阵区域的同学总分最高，并对这个区域的同学进行鼓励。
     * 输入描述
     * 输入第一行为整数N，第二行为N*N个整数组成(空格分割)，代表同学的答题得分的矩阵（行优先，第一行N个数，接着第二行N个数，以此类推）。
     *
     * 输出描述
     * 队伍中一个得分最高的子队伍得分
     */


    public static void main(String[] args) {
        // 深度优先遍历
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] scores = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                scores[i][j] = sc.nextInt();
            }
        }

        int max_score = 0;
        // 遍历
        for (int i = 0; i < N; i ++){
            for (int j = 0; j < N; j ++){
                // 找到开始搜索的位置，也就是土地
                if (scores[i][j] >= 0){
                    // 调用辅函数进行搜索
                    max_score = Math.max(max_score, dfs(scores, i, j, N));
                }
            }
        }
        System.out.println(max_score);
    }

    public static int dfs(int[][] scores, int cur_i, int cur_j, int N){
        // 递归，不是正数就返回
        if (scores[cur_i][cur_j] < 0)
            return 0;
        // 得分
        int score = scores[cur_i][cur_j];
        // 将当前值置为-1，防止后续重复遍历
        scores[cur_i][cur_j] = -1;
        // 四个方向
        int[] direction = new int[]{-1, 0, 1, 0, -1};
        // 向四个方向进行搜索
        for (int i = 0; i < 4; i ++){
            int x = cur_i + direction[i];
            int y = cur_j + direction[i+1];
            // 边界条件，并且这个位置也是正数
            if (x >= 0 && x < N && y >= 0 && y < N){
                // +1+1，递归调用，找到一片完整的区域
                score += dfs(scores, x, y, N);
            }
        }
        return score;
    }

}
