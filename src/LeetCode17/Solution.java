package LeetCode17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangfin
 * @Date 2024/2/29
 * @Desc 电话号码的字母组合
 */
public class Solution {

    String[] charsList = new String[]{"", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        // 这个值用于记录遍历digits
        int startIndex = 0;
        StringBuilder path = new StringBuilder();
        backTracking(digits, startIndex, path, res);

        return res;
    }

    private void backTracking(String digits, int startIndex, StringBuilder path, List<String> res) {
        // 终止条件：长度=输入字符串长度
        if (startIndex == digits.length()) {
            res.add(path.toString());
            return;
        }

        // 循环遍历
        // 因为charAt取出来的是字符的ASCII，所以要减去'0'
        String strChars = charsList[digits.charAt(startIndex) - '0'];
        // 遍历的内容是每个数字对应的字符串
        for (int i = 0; i < strChars.length(); i ++) {
            // 加入最后一个
            path.append(strChars.charAt(i));
            backTracking(digits,startIndex + 1, path, res);
            // 剔除末尾的继续尝试
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "237";
        List<String> res = new Solution().letterCombinations(digits);
        System.out.println(res.toString());
    }

}
