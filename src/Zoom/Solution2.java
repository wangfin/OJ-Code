package Zoom;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution2 {
    public int[] slideWindow (int[] nums, int windowSize, int step) {
        // write code here
        // 边界情况
        if(nums.length < 2) return nums;

        // 返回结果
        int[] result = new int[(nums.length - windowSize)/step + 2];
        // 定义最大值
        // int max = 0;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        // queue中存入的是idx，不是值
        LinkedList<Integer> queue = new LinkedList();

        // 开始遍历nums
        for (int i = 0; i < nums.length; i = i+step){
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                // 弹出队尾的值，直到放入这个当前值
                queue.pollLast();
            }
            // 在queue的尾部添加该元素的下标
            queue.addLast(i);

            // 判断当前队列中队首的值（也就是最大值是否在当前时间窗口内）是否有效
            if(queue.peek() <= i-windowSize){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            // i是右边界
            if(i+1 >= windowSize){
                result[i+1-windowSize] = nums[queue.peek()];
            }

        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int step = 2;
        int[] res = new Solution2().slideWindow(nums, k, step);
        System.out.println(Arrays.toString(res));
        // System.out.println(5/2);
    }
}
