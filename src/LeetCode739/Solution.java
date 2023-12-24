package LeetCode739;

import java.util.*;

public class Solution {
    /**
     * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * @param temperatures
     * @return
     */
    // 暴力方法，全部遍历一遍
//    public int[] dailyTemperatures(int[] temperatures) {
//        // 暴力方法，全部遍历一遍
//        int n = temperatures.length;
//        int[] answer = new int[n];
//        for (int i = 0; i < n; i++){
//            for (int j = i+1; j < n; j++){
//                if (temperatures[j] > temperatures[i]){
//                    answer[i] = j - i;
//                    break;
//                }else{
//                    answer[i] = 0;
//                }
//            }
//        }
//        return answer;
//    }

    /**
     * 单调栈
     * 通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了。
     * 单调栈的本质是空间换时间，因为在遍历的过程中需要用一个栈来记录右边第一个比当前元素的元素，优点是只需要遍历一次。
     * 单调栈里面存放的是元素的下标
     * 整体流程就是，在单调栈里面存入数组的下标，保持整个栈从栈顶到栈底是一个单调递增或递减的序列
     * 例如，设从栈顶到栈底是一个递增的栈， 那么如果后一个元素大于栈顶元素，则需要弹出栈顶元素（循环弹出），
     * 直到将后一个元素安排到正确的位置，同时弹出元素的下标差就是输出结果，下标就是结果数组的下标
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        // 构建单调栈
        Stack<Integer> stack = new Stack<>();
        // 新建栈顶为0号位置
        stack.push(0);
        for (int i = 1; i < len; i++){
            // 小于，正常插入
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else{// 大于，输出结果
                while (!stack.isEmpty()&&temperatures[i] > temperatures[stack.peek()]){
                    // 差值就是输出结果
                    answer[stack.peek()] = i - stack.pop();
                    // 弹出栈顶
                    //stack.pop();
                }
                // 插入新的值
                stack.push(i);
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] answer = new Solution().dailyTemperatures(temperatures);
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]);
        }
    }
}
