package LeetCode179;

import java.util.Arrays;

public class Solution {
    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     *
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     *
     * 输出最大的整数，需要数字越大的放在前面
     *
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     *
     * 输入：nums = [10]
     * 输出："10"
     *
     * 朴素的想法就是，把高位数字大的放在前面
     * 如果高位数字一样的话，比较第二位数字，以此类推
     *
     * 对于 nums 中的任意两个值 a 和 b，我们无法直接从常规角度上确定其大小/先后关系。
     * 但我们可以根据「结果」来决定 a 和 b 的排序关系：
     * 如果拼接结果 ab 要比 ba 好，那么我们会认为 a 应该放在 b 前面。
     * 另外，注意我们需要处理前导零（最多保留一位）。
     *
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        // 将数字转换为字符串
        for (int i = 0; i < n; i++)
            ss[i] = "" + nums[i];
        // 如果ab 要比 ba 好，那么我们会认为 a 应该放在 b 前面
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss)
            sb.append(s);
        int len = sb.length();
        int k = 0;
        // 去掉前导0
        while (k < len - 1 && sb.charAt(k) == '0')
            k++;
        // 返回sb的去掉前导0的子串
        return sb.substring(k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        String res = new Solution().largestNumber(nums);
        System.out.println(res);
    }
}
