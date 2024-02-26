package LeetCode376;

/**
 * @Author wangfin
 * @Date 2024/2/3
 * @Desc 摆动序列
 */
public class Solution2 {

    /**
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
     * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
     *
     */

    /**
     * 这道题看着复杂，前后摆动啥的，其实就是遍历数据，取前后两个字段的差值
     * 同时因为可以删除元素，也就是取最大值，所以不能只获取差值，需要连着之前的差值preDiff
     * 也就是得找到一个高低峰值才能继续找下一个
     * 正常情况preDiff需要<=0且curDiff>=0，反正也是，但是因为在0的情况下需要单独讨论平坡的情况
     * 所以统一把数值相同的左侧给删掉了，即pre<=0 cur=0的情况
     */

    public int wiggleMaxLength(int[] nums) {
        int res = 1;
        int preDiff = 0;
        int curDiff = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            curDiff = nums[i+1] - nums[i];

            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                res ++;
                preDiff = curDiff;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,7,4,9,2,5};
        int res = new Solution2().wiggleMaxLength(nums);
        System.out.println(res);
    }
}
