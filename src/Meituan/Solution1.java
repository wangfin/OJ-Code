package Meituan;

import java.util.Scanner;
import java.util.Stack;

public class Solution1 {
    // 小美的数学题
    // 应该是stack的符号匹配
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        String s = sc.nextLine();
        // 构建深度
        Stack<Integer> stack = new Stack();
        stack.push(1);
        // 得分
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(1);
            }else{
                // 将栈顶元素弹出，并修改栈顶值，计算好的分数
                // 并列表示分数相乘
                // 嵌套表示分数+1
                int v = stack.pop();
                int w = stack.pop();

                stack.push(w * (v + 1));
            }
        }

        System.out.println(stack.pop());

    }
}
