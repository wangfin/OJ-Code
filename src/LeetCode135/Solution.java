package LeetCode135;

public class Solution {
    /**
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     *
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     *
     * 每个孩子至少分配到 1 个糖果。
     * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
     * 那么这样下来，老师至少需要准备多少颗糖果呢？
     *
     * 输入：[1,0,2]
     * 输出：5
     * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
     *
     * 设学生 A 和学生 B 左右相邻，A 在 B 左边；
     * 左规则： 当 ratings_B > ratings_A 时，B 的糖比 A 的糖数量多。
     * 右规则： 当 ratings_A > ratings_B 时，A 的糖比 B 的糖数量多。
     * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
     *
     * 题解，用了一个简单的方式
     * 从左到右和从右到左两次遍历：
     * 首先把所有孩子的糖果数初始化为 1；
     * 先从左往右遍历一遍，如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的糖果数加 1；
     * 再从右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数不大于右边孩子的糖果数，则左边孩子的糖果数更新为右边孩子的糖果数加 1。
     * 通过这两次遍历，分配的糖果就可以满足题目要求了。
     */

    public int candy(int[] ratings) {
        int size = ratings.length;
        // 注意特殊情况
        if (size < 2){
            return size;
        }
        // 初始化数组
        int[] nums = new int[size];
        // 从左到右遍历
        for (int i = 0; i < size; i ++) {
            // 如果右边的分数大于左边的分数
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                // 右边的糖果要比左边的+1
                nums[i] = nums[i - 1] + 1;
            } else {
                // 不大于那就全部设置为1
                nums[i] = 1;
            }
        }
        // 从右到左遍历
        for (int i = size - 1; i > 0; i --){
            // 如果左边的分数大于右边的分数
            if (ratings[i] < ratings[i-1]) {
                // 左边当前的糖果数不大于右边的糖果数，则左边的糖果数更新为右边的糖果数加 1
                nums[i-1] = Math.max(nums[i-1], nums[i] + 1);
            }
        }
        int result = 0;
        for(int num:nums){
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {1,6,7};
        int result = new Solution().candy(ratings);
        System.out.println(result);
    }
}
