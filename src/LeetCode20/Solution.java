package LeetCode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author wangfin
 * @Date 2023/12/27
 * @Desc
 */
public class Solution {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     */

    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public boolean isValid(String s) {

        // 从左到右，遇到左括号就入栈，遇到右括号，看栈首是否匹配，匹配就出栈
        // 最后看堆栈是否清空
        int len = s.length();
        if (len == 0) {
            return true;
        }
        if (len % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                // 遇到左括号就入栈
                stack.push(s.charAt(i));
            } else {
                // 如果左括号都没了，只有右括号也不行
                if (stack.isEmpty()) {
                    return false;
                } else {
                    // 遇到右括号，看是否能出栈
                    if (s.charAt(i) == map.get(stack.peek())) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            }
        }
        // 左括号多了也不行
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean res = new Solution().isValid(s);
        System.out.println(res);
    }

}
