package LeetCode03;

/**
 * @Author wangfin
 * @Date 2023/12/24
 * @Desc
 */
public class Solution1 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * 滑动窗口
     */

    public int lengthOfLongestSubstring(String s) {
        int maxSubstringLen = 0;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        // 滑动窗口
        // 遍历左窗口，右窗口向右移动，如果没重复的+1，有重复了，直接跳到重复的地方+1
        int len = s.length();
        int i = 0;
        int j = 1;
        while (i < len - 1 && j < len) {
            String subString = s.substring(i, j);
            char charJ = s.charAt(j);
            int x = subString.indexOf(charJ);
            if (x < 0) {
                j++;
            } else {
                i = i + x + 1;
                j = i + 1;
            }

            if (j - i > maxSubstringLen) {
                maxSubstringLen = j - i;
            }
        }

        return maxSubstringLen;
    }

    public static void main(String[] args) {
        String s = "aa";
        Solution1 solution1 = new Solution1();
        int res = solution1.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
