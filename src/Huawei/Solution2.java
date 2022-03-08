package Huawei;

import java.util.*;

public class Solution2 {
    /**
     * 根据 逆波兰表示法，求表达式的值。
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表式。
     * 说明：
     * 整数除法只保留整数部分。
     * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0的情况。
     *  示例 1：
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * 示例 2：
     * 输入：tokens = ["4","13","5","/","+"]
     * 输出：6
     * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
     * 示例 3：
     * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * 输出：22
     * int evalRPN(char ** tokens, int tokensSize) {
     * }
     */
    public int evalRPN(String[] tokens, int tokensSize){
        // size为0
        if (tokensSize <= 0){
            return 0;
        }
        // 数字
        Stack<Integer> stack = new Stack<>();
        // 遍历
        for (int i = 0; i < tokensSize; i++){
            String token = tokens[i];
            // 判断是否为数字
            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            }else{
                // 前面的值是后面的
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static boolean isNumber(String token){

        // 判断数字是否为整数
        if ("+".equals(token)){
            return false;
        }else if ("-".equals(token)){
            return false;
        }else if ("*".equals(token)){
            return false;
        }else if ("/".equals(token)){
            return false;
        }else{
            return true;
        }
    }



}
