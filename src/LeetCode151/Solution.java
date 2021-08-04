package LeetCode151;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * 翻转字符串里的单词
     * 给定一个字符串s，逐个翻转字符串中的每个单词。
     * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
     *
     * 说明：
     * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
     * 翻转后单词间应当仅用一个空格分隔。
     * 翻转后的字符串中不应包含额外的空格。
     *
     *
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     * 示例 2：
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     *
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 本题简单的方法可以使用语言特性，使用split，reverse，join等方法
     * 使用 split 将字符串按空格分割成字符串数组；
     * 使用 reverse 将字符串数组进行反转；
     * 使用 join 方法将字符串数组拼成一个字符串。
     *
     * 源字符串为："the sky is blue "
     * 移除多余空格 : "the sky is blue"
     * 字符串反转："eulb si yks eht"
     * 单词反转："blue is sky the"
     *
     * 也可以自己写api，这边就直接抄题解了
     */

    // 使用语言提供的api
//    public String reverseWords(String s) {
//        // 去除开头和末尾的空白字符
//        s = s.trim();
//        // 正则匹配连续的空白字符作为分割符分割
//        List<String> wordlist = Arrays.asList(s.split("\\s+"));
//        Collections.reverse(wordlist);
//        return String.join(" ", wordlist);
//    }

    // 自己编写api
    // 移除多余空格
    // 将整个字符串反转
    // 将每个单词反转
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();

    }

    // 去除空格
    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ')
            start ++;
        while (s.charAt(end) == ' ')
            end --;

        StringBuilder sb = new StringBuilder();
        while (start <= end){
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start ++;
        }
        return sb;
    }

    // 反转字符串指定区间[start, end]的字符
    public void reverseString(StringBuilder sb, int start, int end){
        while(start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start ++;
            end --;
        }
    }

    // 反转每个单词
    private void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n){
            while (end < n && sb.charAt(end) != ' '){
                end ++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
