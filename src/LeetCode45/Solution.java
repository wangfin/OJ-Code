package LeetCode45;

public class Solution {
    /**
     *给定一个非负整数数组，你最初位于数组的第一个位置。
     *数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *
     * 说明:假设你总是可以到达数组的最后一个位置。
     *
     * 在无法到达更远的地方时，在这之前应该跳到一个到达更远位置的位置
     * 简单的说，就是在当前节点能够到达最远位置内，选下一个能够到达更远位置的位置(i + nums[i])
     */

    public int jump(int[] nums) {
        // 当前可达到的最远位置
        int cur_max_index = nums[0];
        // 下一个可以到达的最远位置
        int next_max_index = nums[0];
        // 最小的跳数
        int jump_min = 1;
        // 数组长度为1，不需要跳
        if (nums.length <= 1){
            return 0;
        }

        for (int i = 1; i < nums.length; i ++){
            // i到达目前能够到达的最远位置，并且没有到数组末尾
            if (cur_max_index < i){
                // 最小的跳数+1
                jump_min ++;
                // 当前最大位置改为下一个最大位置
                cur_max_index = next_max_index;
            }
            // 更新下一个最大位置
            if (next_max_index < nums[i] + i){
                next_max_index = nums[i] + i;
            }
        }

        return jump_min;

    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        int res = new Solution().jump(nums);
        System.out.println(res);
    }
}
