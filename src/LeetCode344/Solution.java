package LeetCode344;

public class Solution {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * swap可以有两种实现。
     *
     * 一种就是常见的交换数值：
     * int tmp = s[i];
     * s[i] = s[j];
     * s[j] = tmp;
     *
     * 一种就是通过位运算：
     * s[i] ^= s[j];
     * s[j] ^= s[i];
     * s[i] ^= s[j];
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            //构造 a ^ b 的结果，并放在 a 中
            s[l] ^= s[r];
            //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[r] ^= s[l];
            //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            s[l] ^= s[r];
            l++;
            r--;
        }
    }
}
