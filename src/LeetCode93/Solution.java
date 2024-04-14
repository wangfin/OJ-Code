package LeetCode93;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author wangfin
 * @Date 2024/3/28
 * @Desc 复原 IP 地址
 */
public class Solution {

    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     * 示例 1：
     *
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 示例 2：
     *
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     *
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        Stack<String> path = new Stack<>();


        if (s.length() > 12) return res; // 算是剪枝了
        backTracking(s, 0, path, res);
        return res;
    }

    public void backTracking(String s, int startIndex, Stack<String> path, List<String> res) {
        // 终止条件
        if (path.size() == 4) {
            String ip = StringUtils.join(path, ".");
            if (ip.length() == s.length() + 3) {
                res.add(ip);
                return;
            }
        }

        // 遍历
        for (int i = startIndex; i < s.length(); i ++) {
            if (i - startIndex > 3) {
                return;
            }
            // 如果切分出来的字符串是合法的，就加入
            if (isValid(s, startIndex, i)) {
                String str = s.substring(startIndex, i);
                path.push(str);
            } else {
                continue;
            }

            backTracking(s, i + 1, path, res);
            path.pop();
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(String s, int start, int end) {

        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new Solution().restoreIpAddresses(s);
        System.out.println(res.toString());
    }
}
