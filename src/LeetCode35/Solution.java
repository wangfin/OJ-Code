package LeetCode35;

public class Solution {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     *
     * 暴力解法就是全部走一遍
     * 四种情况：
     *  目标值在数组所有元素之前
     *  目标值等于数组中某一个元素
     *  目标值插入数组中的位置
     *  目标值在数组所有元素之后
     *
     *
     * 二分查找
     * 因为数组是一个有序数组，这是使用二分查找的基础
     * 二分查找
     */
//    // 暴力解法
//    public int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++){
//            // 分别处理如下三种情况
//            // 目标值在数组所有元素之前
//            // 目标值等于数组中某一个元素
//            // 目标值插入数组中的位置
//            if (nums[i] >= target){
//                // 一旦发现大于或者等于target的num[i]，那么i就是我们要的结果
//                return i;
//            }
//        }
//        // 目标值在数组所有元素之后的情况
//        return nums.length; // 如果target是最大的，或者 nums为空，则返回nums的长度
//    }

    // 二分查找 左闭右闭的区间 [left, right]
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // 定义target在左闭右闭的区间里，[left, right]
        int left = 0;
        int right = n - 1;

        while (left <= right){
            // 防止溢出 等同于(left + right)/2
            int middle = left + ((right - left) / 2);
            // 区间的两边都能取到
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle;
            }

        }

        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1
        return right + 1;
    }

    // 在左闭右开的区间里，也就是[left, right)
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n; // 定义target在左闭右开的区间里，[left, right)  target
        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间
            // 这种也是/2的意思
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle; // target 在左区间，在[left, middle)中
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，在 [middle+1, right)中
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值的情况，直接返回下标
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前 [0,0)
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
        return right;
    }



}
