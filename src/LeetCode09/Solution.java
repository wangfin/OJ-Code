package LeetCode09;

public class Solution {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * 第一个想法是双指针，从前往后，从后往前
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     * 所以用数字的方法，除10*n得到第一位，%10得到最后一位
     */
    public boolean isPalindrome(int x) {
        // 小于0的负数不是
        if (x<0)
            return false;

        int div = 1;
        // 求这个值的位数
        while (x / div >= 10){
            div *= 10;
        }
        while (x > 0){
            int left = x / div;
            int right = x % 10;
            if (left != right)
                return false;
            // 去掉首尾的字符
            x = (x % div) / 10;
            // 少两位
            div /= 100;
        }
        return true;
    }
}
