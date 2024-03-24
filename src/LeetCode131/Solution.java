package LeetCode131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangfin
 * @Date 2024/3/18
 * @Desc 分割回文串
 */
public class Solution {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
     *
     * 示例 1：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * 输入：s = "a"
     * 输出：[["a"]]
     */

    /**
     * 回溯算法
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> path = new Stack<>();

        backTracking(s, 0, path, res);

        return res;
    }

    private void backTracking(String s, int startIndex, Stack<String> path, List<List<String>> res) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            res.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文字符串则加入path中
            if (isPalindrome(s, startIndex, i)) {
                String sStr = s.substring(startIndex, i + 1);
                path.push(sStr);
            } else {
                continue;
            }

            backTracking(s, i + 1, path, res);
            path.pop();
        }
    }

    /**
     * 判断是否为回文
     */
    private boolean isPalindrome(String s, int startIndex, int end) {
        while (startIndex < end) {
            if (s.charAt(startIndex++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
        System.out.println(solution.partition("a"));
    }

}
