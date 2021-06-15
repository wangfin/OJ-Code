package LeetCode402;

import java.util.Stack;

public class Solution {
    /**
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * 返回的是字符串
     * 注意:
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     *
     * 贪心+单调栈
     * 若要使得剩下的数字最小，需要保证靠前的数字尽可能小。
     * 策略：
     * 从高位向低位遍历，如果对应的数字大于下一位数字，则把该位数字去掉，得到的数字最小；如果不存在，说明整个数字序列单调不降，删去最后一个数字即可。
     * 方法：
     * 用一个栈维护当前的答案序列，栈中的元素代表截止到当前位置，删除不超过 k 次个数字后，所能得到的最小整数。
     * 根据之前的讨论：在使用 k 个删除次数之前，栈中的序列从栈底到栈顶单调不降。
     * 因此，对于每个数字，如果该数字小于栈顶元素，我们就不断地弹出栈顶元素，直到
     *  - 栈为空
     *  - 或者新的栈顶元素不大于当前数字
     *  - 或者已经删除了 k 位数字
     *
     * 额外情况：
     *  - 如果删除了 m 个数字且 m<k，这种情况下需要从序列尾部删除额外的 k-m 个数字。
     *  - 如果最终的数字序列存在前导零，要删去前导零。
     *  - 如果最终数字序列为空，应该返回 0。
     *
     */
    public String removeKdigits(String num, int k) {
        // 构建一个栈
        Stack<Integer> stack = new Stack<>();
        // 输出的结果
        StringBuilder result = new StringBuilder("");

        for (int i = 0 ; i < num.length(); i ++){
            // 获取每个位置的数字
            int number = num.charAt(i) - '0';
            // 如果stack不为空，并且前一位数字大于后一位数字的，k>0
            while (!stack.isEmpty() && (stack.peek() > number) && (k > 0)){
                // 弹出栈顶元素
                stack.pop();
                k --;
            }
            //栈为空，且当前位为0时，不需要将其入栈（删除前导0）
            if(stack.isEmpty() && number == 0){
                continue;
            }
            // 将数字压入stack中
            stack.push(number);
        }
        // 如果是单调递增的数组，直接删除最后几位数字
        while (!stack.isEmpty() && k > 0){
            // 弹出栈顶元素
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()) {
            int digit = stack.pop();
            result.insert(0, digit);
        }

        // 结果为空，删没了
        if (result.length() == 0){
            result.append("0");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        String res = new Solution().removeKdigits(num, k);
        System.out.println(res);
    }
}
