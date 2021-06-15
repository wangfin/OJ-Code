package LeetCode239;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 简单想法：
     * 最简单朴素的想法就是，把区间内的作比较，取出最大值，但是可想而知复杂度很高
     * 这个很明显超时了
     *
     * 优化思路：
     * 因为滑动窗口是有前后关系的，保存上一个窗口的最大值，在根据删除的和新加入的值的比较，可以简化操作
     * 看到了题解的双向队列，用来保存最大值
     * 遍历数组，将数存放在双向队列中，并用 L,R 来标记窗口的左边界和右边界。
     * 队列中保存的并不是真的 数，而是该数值对应的数组下标位置，并且数组中的数要从大到小排序。
     * 如果当前遍历的数比队尾的值大，则需要弹出队尾值，直到队列重新满足从大到小的要求。
     * 刚开始遍历时，L 和 R 都为 0，有一个形成窗口的过程，此过程没有最大值，L 不动，R 向右移。
     * 当窗口大小形成时，L 和 R 一起向右移，
     * 每次移动时，判断队首的值的数组下标是否在 [L,R] 中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。
     *
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 边界情况
        if(nums.length < 2) return nums;

        // 返回结果
        int[] result = new int[nums.length - k + 1];
        // 定义最大值
        int max = 0;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        // queue中存入的是idx，不是值
        LinkedList<Integer> queue = new LinkedList();

        // 开始遍历nums
        for (int i = 0; i < nums.length; i++){
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                // 弹出队尾的值，直到放入这个当前值
                queue.pollLast();
            }
            // 在queue的尾部添加该元素的下标
            queue.addLast(i);

            // 判断当前队列中队首的值（也就是最大值是否在当前时间窗口内）是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            // i是右边界
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new Solution().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

}
