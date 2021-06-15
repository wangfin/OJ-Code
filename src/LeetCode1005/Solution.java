package LeetCode1005;

import java.util.Arrays;
import java.util.Comparator;


public class Solution {
    /**
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。
     * （我们可以多次选择同一个索引 i。）
     *
     * 以这种方式修改数组后，返回数组可能的最大和。
     *
     * 贪心的思路，局部最优：让绝对值大的负数变为正数，当前数值达到最大，整体最优：整个数组和达到最大。
     * 那么如果将负数都转变为正数了，K依然大于0，此时的问题是一个有序正整数序列，如何转变K次正负，让 数组和 达到最大。
     *
     * 那么又是一个贪心：局部最优：只找数值最小的正整数进行反转，当前数值可以达到最大
     * （例如正整数数组{5, 3, 1}，反转1 得到-1 比 反转5得到的-5 大多了），全局最优：整个 数组和 达到最大。
     */


    public int largestSumAfterKNegations(int[] A, int K) {
        // 比较器
//        Arrays.sort(A, new Comparator<Integer>() {
//            // 自定义比较器，定义如何设置优先级
//            @Override
//            public int compareTo(int a, int b) {
//                return a.compareTo(b);
//            }
//        });
        for (int i = 0; i < A.length; i ++){
            if (A[i] < 0 && K > 0){
                A[i] *= -1;
                K --;
            }
        }
        while (K != 0){
            A[A.length - 1] *= -1;
            K --;
        }
        int result = 0;
        for (int a: A)
            result += a;

        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int res = new Solution().largestSumAfterKNegations(A,1);
    }
}
