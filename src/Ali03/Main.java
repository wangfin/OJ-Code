package Ali03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    /**
     * 小强现在有n个物品,每个物品有两种属性xi和yi.他想要从中挑出尽可能多的物品满足以下条件:
     * 对于任意两个物品i和j,满足xi<xj且yi<yj或者xi>xj且yi>yj，问最多能挑出多少物品.
     */
    public static void main(String[] args) {
        // 读取数据
        Scanner sc = new Scanner(System.in) ;
        int T = sc.nextInt();
        for (int t = 0; t < T; t++){
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++){
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++){
                y[i] = sc.nextInt();
            }
        }

        // 算法部分
        // 一开始想的回溯算法，但是并不知道多少个组合
        // 采用最长子序列
        /**
         * 题目可以转换为这样的一个想法：
         * 选一些上升的x，他们的y也是上升的（这个不需要考虑中间的上升下降问题，因为排完序之后最后的结果一定是一个x,y均有序上升的序列），
         * 然后进行结构体排序，x上升，x相同的情况下y更大的排序在前面（不然的话会重复统计相同的x），
         * 然后对y做一次最长上升子序列即可（这里的复杂度需要用nlog的做法，而不是n方的dp做法）
         */


    }


}
