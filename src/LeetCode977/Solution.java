package LeetCode977;

public class Solution {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *
     * 简单思路就是先平方，再排序，这个时间复杂度是 O(n + nlogn)， 可以说是O(nlogn)的时间复杂度
     * O(nlogn)是快排的时间复杂度
     *
     * 改进版本：双指针
     * 数组其实是有序的， 只不过负数平方之后可能成为最大数了。
     * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
     * 此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
     * 定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。
     * 如果A[i] * A[i] < A[j] * A[j] 那么result[k--] = A[j] * A[j]; 。
     * 如果A[i] * A[i] >= A[j] * A[j] 那么result[k--] = A[i] * A[i]; 。
     * 简单来说，一个指针在最前面，一个指针在最后面，想中间靠拢
     * 最大值肯定是在边界的值，所以只需要比较两个指针所指向的值就行
     */
    public int[] sortedSquares(int[] nums) {
        // 返回结果
        int[] res = new int[nums.length];
        // 左指针
        int left = 0;
        // 右指针
        int right = nums.length - 1;
        // res的最后一个值，也就是从最大值开始记录
        int index = res.length - 1;
        // 二分
        while (left <= right){
            // 左指针的平方比较大，存储左指针的值
            if (nums[left] * nums[left] > nums[right] * nums[right]){
                res[index --] = nums[left] * nums[left];
                // 左指针++
                ++left;
            }else{ // 右指针
                res[index--] = nums[right] * nums[right];
                // 右指针--
                --right;
            }
        }
        return res;
    }
}
