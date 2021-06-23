package Offer15;

public class Solution {
    /**
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
     * 例如，把 9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     *
     * java api bitcount
     * 与运算
     * 若 n&1=0 ，则 n 二进制 最右一位 为 0 ；
     * 若 n&1=1 ，则 n 二进制 最右一位 为 1 。
     * 根据以上特点，考虑以下 循环判断 ：
     * 判断 n 最右一位是否为 1 ，根据结果计数。
     * 将 n 右移一位（本题要求把数字 n 看作无符号数，因此使用 无符号右移 操作）。
     *
     */
//    public int hammingWeight(int n) {
//        // return Integer.bitCount(n);
//
//        /**
//         * 初始化数量统计变量 res=0 。
//         * 循环逐位判断： 当 n=0 时跳出。
//         *     res += n & 1 ： 若 n&1=1 ，则统计数 res 加一。
//         *     n >>= 1 ： 将二进制数字 n 无符号右移一位（ Java 中无符号右移为 ">>>" ） 。
//         * 返回统计数量 resres 。
//         */
//        int res = 0;
//        while (n != 0){
//            res += n & 1;
//            n >>>= 1;
//        }
//        return res;
//    }


    /**
     * (n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
     * n&(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
     *
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        int res = new Solution().hammingWeight(n);
        System.out.println(res);
    }


}
