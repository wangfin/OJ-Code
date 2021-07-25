package LeetCode03;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例1：
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 采用滑动窗口，从左到右扫描
     * 使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着「枚举子串的起始位置」，而右指针即为 r_k（向右侧探索边界）
     *
     * 在每一步的操作中，会将左指针向右移动一格，表示开始枚举下一个字符作为起始位置，
     * 然后可以不断地向右移动右指针，但需要保证这两个指针对应的子串中没有重复的字符。
     * 在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。记录下这个子串的长度；
     *
     * 在枚举结束后，找到的最长的子串的长度即为答案。
     *
     * 使用HashSet判断是否有重复字符
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        // 设置Set
        Set<Character> set = new HashSet<Character>();
        // 右指针，初始值为 -1，相当于在字符串的左边界的左侧，还没有开始移动
        // i就是左指针
        int rk = -1, ans = 0;
        // 每一次左指针向右边移动一格，从当前位置的左指针开始探索最长的不重复子串
        for(int i = 0; i < s.length(); i++){
            if (i != 0) {
                // 左指针向右移动一格，移除最左边的字符
                set.remove(s.charAt(i - 1));
            }
            // rk+1 没有到达边界 并且 set中不存在相同的字符
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针，并且把rk+1的字符存入Set中
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            // 比较选出最大值
            ans = Math.max(ans, rk - i + 1);
            // 如果需要保存最长无重复子串的内容的话，需要保留左右边界的位置
        }
        return ans;
    }
}
