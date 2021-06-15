package LeetCode07;

public class Solution {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) { // 溢出!!!
                return 0;
            }
            res = tmp;
            x /= 10;
        }
        return res;
    }
}
