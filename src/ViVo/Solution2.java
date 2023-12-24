package ViVo;

import java.util.*;

public class Solution2 {
    /**
     *
     * @param p 第i个房间能住的人数
     * @param c 第i个房间所需的成本
     * @param r 第i种房间的个数
     * @param n 有 n 个员工
     * @return 最小成本让所有员工入住
     *
     * 动态规划
     */
    public int minCost(ArrayList<Integer> p, ArrayList<Integer> c, ArrayList<Integer> r, int n){
        // 成本
        int[] dp = new int[n+1];
        int room_num = p.size();
        int room_sum = 0;

        // 判空处理
        for (int i = 0; i < room_num; i++){
            room_sum += p.get(i);
        }
        if (room_sum < n){
            return -1;
        }
        // 从头遍历房间
        for (int i = 0; i < room_num; i++){
            // 遍历人数
            for (int j = n; j >= p.get(i); j--){
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= r.get(i) && (j - k * p.get(i)) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * p.get(i)] + k * c.get(i));
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ArrayList<Integer> p = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(500, 600, 750, 960));
        ArrayList<Integer> r = new ArrayList<>(Arrays.asList(2, 2, 1, 1));
        int n = 6;
        int res = new Solution2().minCost(p, c, r, n);
        System.out.print(res);
    }
}
