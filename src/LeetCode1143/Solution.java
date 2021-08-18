package LeetCode1143;

public class Solution {
    /**
     * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *
     * 本题和LeetCode718. 最长重复子数组区别在于这里不要求是连续的了，
     * 但要有相对顺序，即："ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 动态规划
     * dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
     * 这边设置的是i-1，不是i，也可以设置为i
     * 递推公式：
     * 主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
     * 如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
     * 如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列
     * 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
     * 即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 这边因为用的是i-1，所以需要多一个
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        // 开始遍历
        for (int i = 1; i <= text1.length(); i++){
            // dp[i]表示i-1
            char char1 = text1.charAt(i-1);
            for (int j = 1; j <= text2.length(); j++){
                char char2 = text2.charAt(j-1);
                // 相等
                if (char1 == char2){
                    // 继续加
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    // 如果不相等，那么就取前面的最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
