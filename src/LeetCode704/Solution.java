package LeetCode704;

public class Solution {
    /**
     *
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 提示：
     * 你可以假设 nums 中的所有元素是不重复的。
     *
     * 有序数组+无重复元素=二分法
     * 二分法主要对区间进行定义
     *
     * 第一种写法，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right] （这个很重要非常重要）。
     *
     * 区间的定义这就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
     *
     * while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
     * if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，
     * 那么接下来要查找的左区间结束下标位置就是 middle - 1
     */
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            // 左移运算符，num << 1,相当于num乘以2
            // 右移运算符，num >> 1,相当于num除以2
            // 无符号右移，忽略符号位，空位都以0补齐
            // 求中间位置
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){// target在右边区间
                left = mid + 1;
            } else if (nums[mid] > target){// target在左边区间
                right = mid - 1;
            }
        }
        return -1;
    }
}
