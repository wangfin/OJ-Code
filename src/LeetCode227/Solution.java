package LeetCode227;

import java.util.Stack;

public class Solution {
    /***
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 整数除法仅保留整数部分。
     * 输入：s = "3+2*2"
     * 输出：7
     * 输入：s = " 3/2 "
     * 输出：1
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     *
     * 这个跟那个括号消除挺像的，使用堆栈
     * 先乘除，再加减（没有括号），相同的从左往右
     * 设置一个栈，用于放数字
     * 遇到乘除开始计算，加减先放一边，减号是加负数
     * 遇到符号之后，开始记录符号后面的数字，注意数字不一定是个位数
     * 如果是+号，压入后一位数字；如果是-号，压入后一位数字的负数
     * 如果是*号，直接将后一位数字与栈顶数字相乘；如果是/号，直接将后一位数字与栈顶数字相除；然后把计算结果压入栈
     * 最后计算栈内所有的数值
     */
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        char preSign = '+';
        Stack<Integer> number = new Stack<Integer>();
        for (int i = 0 ; i < s.length(); ++i){
            // 如果是数字的话，因为可能不止一位是数字，需要把数字完整的取出来
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 如果是符号，这里的判断细节很重要
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(preSign == '+'){
                    // 如果是+号，压入后一位数字
                    number.push(num);
                } else if(preSign == '-'){
                    // 如果是-号，压入后一位数字的负数
                    number.push(-num);
                } else if(preSign == '*'){
                    // 如果是*号，直接将后一位数字与栈顶数字相乘
                    int sum = number.pop() * (num);
                    number.push(sum);
                } else if(preSign == '/'){
                    // 如果是/号，直接将后一位数字与栈顶数字相除
                    int sum = number.pop() / num;
                    number.push(sum);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }

        while (!number.isEmpty()){
            result = result + number.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(new Solution().calculate(s));
    }
}
