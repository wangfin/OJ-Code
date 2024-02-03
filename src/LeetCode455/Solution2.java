package LeetCode455;

import java.util.Arrays;

/**
 * @Author wangfin
 * @Date 2024/1/24
 * @Desc 分发饼干
 */
public class Solution2 {

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。
     * 如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     *
     * 基本原理：
     * 1.如果某个糖果不能满足某个孩子，那么他也不能满足需求更大的孩子
     * 2.某个孩子可以用更小的糖果满足，那么就不需要更大的糖果满足，可以保留更大的糖果给需求更大的孩子（贪心）
     * 3.需求小的孩子更容易被满足，优先从需求小的孩子尝试
     *
     * 方法：
     * 1.对需求和糖果大小进行升序排序
     * 2.按照从小到大的顺序使用糖果尝试是否可以满足某个孩子，每个糖果只试一次
     * 若成功，则换下一个孩子，直到没有更多的孩子或者没有更多的糖果。
     *
     */
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        // 对需求和糖果进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        // 遍历糖果，因为糖果不管能不能满足都必须得过
        for (int i = 0; i < s.length; i++) {
            if (child == g.length) {
                break;
            }

            if (s[i] >= g[child]) {
                child++;
            }
        }

        return child;
    }


}
