package Offer05;

public class Solution {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * 在 Python 和 Java 等语言中，字符串都被设计成「不可变」的类型，即无法直接修改字符串的某一位字符，需要新建一个字符串实现。
     *
     * 算法流程：
     * 1.初始化一个 list (Python) / StringBuilder (Java) ，记为 res ；
     * 2.遍历列表 s 中的每个字符 c ：
     *   1.当 c 为空格时：向 res 后添加字符串 "%20" ；
     *   2.当 c 不为空格时：向 res 后添加字符 c ；
     * 3.将列表 res 转化为字符串并返回。
     *
     */
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (Character c: s.toCharArray()){
            if (c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String res = new Solution().replaceSpace(s);
        System.out.println(res);
    }
}
